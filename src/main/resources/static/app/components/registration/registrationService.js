"use strict";

var registrationServices = angular.module('registrationServices', ['ngResource']);

registrationServices.factory('registrationService', ['$http', '$q',
    function ($http, $q) {
        return {
            save: function (registration) {
                console.log(registration);
                return $http.post('/register', JSON.stringify(registration), config)
                    .success(function (response) {
                        return response.data
                    });
            }
        };
    }
]);