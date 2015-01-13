'use strict';

angular.module('scrumshuffleApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('scrumshuffle', {
                parent: 'site',
                url: '/scrumshuffle',
                data: {
                    roles: []
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/scrumshuffle/scrumshuffle.html',
                        controller: 'ScrumShuffleController'
                    }
                },
                resolve: {
                    mainTranslatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader) {
                        $translatePartialLoader.addPart('shuffle');
                        return $translate.refresh();
                    }]
                }
            });
    });
