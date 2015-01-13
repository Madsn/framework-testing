'use strict';

angular.module('scrumshuffleApp')
    .factory('TeamMember', function ($resource) {
        return $resource('api/teamMembers/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'next': { method: 'GET', url: 'api/teamMembers/cycle' }
        });
    });
