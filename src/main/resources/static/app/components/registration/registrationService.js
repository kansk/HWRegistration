"use strict";

var registrationServices = angular.module('registrationServices', ['ngResource']);

registrationServices.factory('registrationService', ['$http', '$q',
    function ($http, $q) {
        var currentRegistration = {};

        return {
            save: function (registration) {
                console.log(registration);
                return $http.post('/register', JSON.stringify(registration), config)
                    .success(function (response) {
                        currentRegistration = registration;
                        return response.data
                    });
            },
            getCurrentRegistration: function() {
                return currentRegistration;

            }
        };
    }
]);