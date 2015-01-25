/// <reference path="../../bower_components/dt-angular/angular.d.ts" />

'use strict';

module client {
  angular.module('client', ['ngAnimate', 'ngCookies', 'ngTouch', 'ngSanitize', 'ngResource', 'ui.router', 'ngMaterial'])
    .controller('MainCtrl', MainCtrl)
    .controller('MembersCtrl', MembersCtrl)
    .controller('LayoutCtrl', LayoutCtrl)

  .config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
      .state('home', {
        url: '/',
        templateUrl: 'app/main/main.html',
        controller: 'MainCtrl'
      })
    .state('member', {
        url: '/members',
        templateUrl: 'app/members/members.html',
        controller: 'MembersCtrl'
      });

    $urlRouterProvider.otherwise('/');
  })
;
}
