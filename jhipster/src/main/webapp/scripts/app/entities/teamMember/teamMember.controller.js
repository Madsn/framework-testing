'use strict';

angular.module('scrumshuffleApp')
    .controller('TeamMemberController', function ($scope, TeamMember) {
        $scope.teamMembers = [];
        $scope.loadAll = function() {
            TeamMember.query(function(result) {
               $scope.teamMembers = result;
            });
        };
        $scope.loadAll();

        $scope.create = function () {
            TeamMember.save($scope.teamMember,
                function () {
                    $scope.loadAll();
                    $('#saveTeamMemberModal').modal('hide');
                    $scope.clear();
                });
        };

        $scope.update = function (id) {
            $scope.teamMember = TeamMember.get({id: id});
            $('#saveTeamMemberModal').modal('show');
        };

        $scope.delete = function (id) {
            $scope.teamMember = TeamMember.get({id: id});
            $('#deleteTeamMemberConfirmation').modal('show');
        };

        $scope.confirmDelete = function (id) {
            TeamMember.delete({id: id},
                function () {
                    $scope.loadAll();
                    $('#deleteTeamMemberConfirmation').modal('hide');
                    $scope.clear();
                });
        };

        $scope.clear = function () {
            $scope.teamMember = {initials: null, name: null, id: null};
        };
    });
