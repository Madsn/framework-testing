'use strict';

angular.module('scrumshuffleApp')
    .controller('LogoutController', function (Auth) {
        Auth.logout();
    });
