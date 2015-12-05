'use strict';

var HWRegistrationApp = angular.module('HWRegistrationApp', [
    'ngRoute',
    'ngResource',
    'registrationControllers',
    'registrationServices'
]);

var config = {
    headers: {
        'Accept': 'application/json;version=1',
        'Content-Type': 'application/json'
    }
};

HWRegistrationApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'app/components/registration/registration.html',
                controller: 'RegistrationCtrl'
            }).when('/registration', {
                templateUrl: 'app/components/registration/registration.html',
                controller: 'RegistrationCtrl'
            }).
            otherwise({redirectTo : "/register"});
    }]);