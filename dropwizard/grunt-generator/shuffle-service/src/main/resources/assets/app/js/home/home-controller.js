var myApp = angular.module('shuffle');

myApp.factory('MembersResource', function ($resource) {
  return $resource('/members', {}, {});
});

myApp.controller('HomeController', ['$scope', 'MembersResource', function ($scope, MembersResource) {

}]);
