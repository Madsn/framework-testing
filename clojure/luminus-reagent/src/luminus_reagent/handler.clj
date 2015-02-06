(ns luminus-reagent.handler
  (:require [compojure.core :refer [defroutes]]
            [luminus-reagent.routes.home :refer [home-routes]]
            [luminus-reagent.middleware :refer [load-middleware]]
            [luminus-reagent.session-manager :as session-manager]
            [noir.response :refer [redirect]]
            [noir.util.middleware :refer [app-handler]]
            [ring.middleware.defaults :refer [site-defaults]]
            [compojure.route :as route]
            [taoensso.timbre :as timbre]
            [taoensso.timbre.appenders.rotor :as rotor]
            [selmer.parser :as parser]
            [environ.core :refer [env]]
            [cronj.core :as cronj]
            [luminus-reagent.routes.auth :refer [auth-routes]]
            [luminus-reagent.db.schema :as schema]))

(defroutes
  base-routes
  (route/resources "/")
  (route/not-found "Not Found"))

(defn init
  "init will be called once when\r
   app is deployed as a servlet on\r
   an app server such as Tomcat\r
   put any initialization code here"
  []
  (timbre/set-config!
    [:appenders :rotor]
    {:min-level :info,
     :enabled? true,
     :async? false,
     :max-message-per-msecs nil,
     :fn rotor/appender-fn})
  (timbre/set-config!
    [:shared-appender-config :rotor]
    {:path "luminus_reagent.log", :max-size (* 512 1024), :backlog 10})
  (if (env :dev) (parser/cache-off!))
  (cronj/start! session-manager/cleanup-job)
  (if-not (schema/initialized?) (schema/create-tables))
  (timbre/info
    "
-=[ luminus-reagent started successfully"
    (when (env :dev) "using the development profile")
    "]=-"))

(defn destroy
  "destroy will be called when your application\r
   shuts down, put any clean up code here"
  []
  (timbre/info "luminus-reagent is shutting down...")
  (cronj/shutdown! session-manager/cleanup-job)
  (timbre/info "shutdown complete!"))

(def session-defaults
 {:timeout (* 60 30), :timeout-response (redirect "/")})

(defn- mk-defaults
  "set to true to enable XSS protection"
  [xss-protection?]
  (-> site-defaults
   (update-in [:session] merge session-defaults)
   (assoc-in [:security :anti-forgery] xss-protection?)))

(def app
 (app-handler
   [auth-routes home-routes base-routes]
   :middleware
   (load-middleware)
   :ring-defaults
   (mk-defaults false)
   :access-rules
   []
   :formats
   [:json-kw :edn :transit-json]))

