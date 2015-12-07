"use strict";

var reportServices = angular.module('reportServices', ['ngResource']);

reportServices.factory('reportService', ['$http',
    function ($http) {
        return {
            getReport: function () {
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