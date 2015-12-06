'use strict';

var HWRegistrationApp = angular.module('HWRegistrationApp', [
    'ngRoute',
    'ngResource',
    'jcs-autoValidate',
    'datatables',
    'registrationControllers',
    'registrationServices',
    'reportControllers',
    'reportServices'
]).run([
    'validator',
    'foundation5ElementModifier',
    function (validator, foundation5ElementModifier) {
        validator.setDefaultElementModifier(foundation5ElementModifier.key);
    }]);

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
            }).when('/report', {
                templateUrl: 'app/components/report/report.html',
                controller: 'ReportCtrl'
            }).
            otherwise({redirectTo : "/blah"});
    }]);