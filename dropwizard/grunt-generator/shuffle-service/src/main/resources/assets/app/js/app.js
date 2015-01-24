// Declare app level module which depends on filters, and services
angular.module('shuffle', ['ngResource', 'ngRoute', 'ui.bootstrap', 'ui.date'])
  .config(['$routeProvider', function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/home/home.html',
        controller: 'HomeController'})
      .when('/members', {
        templateUrl: 'views/home/members.html',
        controller: 'MemberController'
      })
      .otherwise({redirectTo: '/'});
  }]);
