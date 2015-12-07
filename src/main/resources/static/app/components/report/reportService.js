"use strict";

var reportServices = angular.module('reportServices', ['ngResource']);

reportServices.factory('reportService', ['$http', '$q',
    function ($http, $q) {
        return {
            getReport: function (registration) {
                console.log(registration);
                return $http.get('/register', config)
                    .success(function (response) {
                        return response
                    });
            },
            deleteRegistrations: function () {
                return $http.delete('/register', config)
                    .success(function (response) {
                        return response
                    });
            }
        };
    }
]);