'use strict';

angular.module('scrumshuffleApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('teamMember', {
                parent: 'entity',
                url: '/teamMember',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/teamMember/teamMembers.html',
                        controller: 'TeamMemberController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('teamMember');
                        return $translate.refresh();
                    }]
                }
            })
            .state('teamMemberDetail', {
                parent: 'entity',
                url: '/teamMember/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/teamMember/teamMember-detail.html',
                        controller: 'TeamMemberDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('teamMember');
                        return $translate.refresh();
                    }]
                }
            });
    });
