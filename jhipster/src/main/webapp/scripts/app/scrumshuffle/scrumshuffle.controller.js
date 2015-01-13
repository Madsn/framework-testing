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

        $scope.random = function() {
            $scope.nextRandomMember = $scope.teamMembers[Math.floor(Math.random() * $scope.teamMembers.length)];
        };
    });
