'use strict';

angular.module('scrumshuffleApp')
    .controller('TeamMemberDetailController', function ($scope, $stateParams, TeamMember) {
        $scope.teamMember = {};
        $scope.load = function (id) {
            TeamMember.get({id: id}, function(result) {
              $scope.teamMember = result;
            });
        };
        $scope.load($stateParams.id);
    });
