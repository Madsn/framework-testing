package controllers

import play.api.db.slick.DBAction
import play.api.libs.json.Json._
import play.api.mvc._

import scala.slick.lifted.Query

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def members = DBAction { implicit rs =>
    val members = Query()
    Ok(toJson(members))
  }

  def memberModify(id: Long) = Action {
    Ok("TODO")
  }

  def memberDelete(id: Long) = Action {
    Ok("TODO")
  }

}