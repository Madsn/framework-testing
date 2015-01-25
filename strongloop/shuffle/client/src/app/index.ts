/// <reference path="../../bower_components/dt-angular/angular.d.ts" />

'use strict';

module client {
  angular.module('client', ['ngAnimate', 'ngCookies', 'ngTouch', 'ngSanitize', 'restangular', 'ui.router', 'ui.bootstrap'])
    .controller('MainCtrl', MainCtrl)
    .controller('MembersCtrl', MembersCtrl)
    .controller('LayoutCtrl', LayoutCtrl)
    .directive('sampleDirective', SampleDirective.Factory())

    .config(function ($stateProvider, $urlRouterProvider) {
      $stateProvider
        .state('home', {
          url: '/',
          templateUrl: 'app/main/main.html',
          controller: 'MainCtrl'
        })
        .state('members', {
          url: '/members',
          templateUrl: 'app/members/members.html',
          controller: 'MembersCtrl'
        });

      $urlRouterProvider.otherwise('/');
    })
  ;
}
