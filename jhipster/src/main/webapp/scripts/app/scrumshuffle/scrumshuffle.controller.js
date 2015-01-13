'use strict';

angular.module('scrumshuffleApp')
    .controller('ScrumShuffleController', function ($scope, TeamMember) {
        $scope.teamMembers = [];
        $scope.loadAll = function() {
            TeamMember.query(function(result) {
                $scope.teamMembers = result;
            });
        };
        $scope.loadAll();

        $scope.cycle = function(){
            TeamMember.next(function(result) {
                $scope.nextMember = result;
            });
        };
    });
