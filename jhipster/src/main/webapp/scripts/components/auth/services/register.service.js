'use strict';

angular.module('scrumshuffleApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


