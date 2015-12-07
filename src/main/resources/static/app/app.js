'use strict';

var HWRegistrationApp = angular.module('HWRegistrationApp', [
    'ngRoute',
    'ngResource',
    'ngAnimate',
    'jcs-autoValidate',
    'datatables',
    'registrationControllers',
    'registrationServices',
    'reportControllers',
    'reportServices',
    'confirmationControllers'
]).run([
    'validator',
    'foundation5ElementModifier',
    function (validator, foundation5ElementModifier) {
        validator.setDefaultElementModifier(foundation5ElementModifier.key);
    }]);

angular.module('jcs-autoValidate')
    .run([
        'defaultErrorMessageResolver',
        function (defaultErrorMessageResolver) {
            defaultErrorMessageResolver.getErrorMessages().then(function (errorMessages) {
                errorMessages['zipCodeErrorMessage'] = 'Enter a zip code in the form "12345" or "12345-6789"';
            });
        }
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
            }).when('/report', {
                templateUrl: 'app/components/report/report.html',
                controller: 'ReportCtrl'
            }).when('/confirmation', {
                templateUrl: 'app/components/confirmation/confirmation.html',
                controller: 'ConfirmationCtrl'
            }).
            otherwise({redirectTo: "/"});
    }]);

HWRegistrationApp.directive('modalDialog', function() {
    return {
        restrict: 'E',
        scope: {
            show: '='
        },
        replace: true, // Replace with the template below
        transclude: true, // we want to insert custom content inside the directive
        link: function(scope, element, attrs) {
            scope.dialogStyle = {};
            if (attrs.width)
                scope.dialogStyle.width = attrs.width;
            if (attrs.height)
                scope.dialogStyle.height = attrs.height;
            scope.hideModal = function() {
                scope.show = false;
            };
        },
        template: "<div class='ng-modal' ng-show='show'>" +
        "<div class='ng-modal-overlay' ng-click='hideModal()'></div>" +
        "<div class='ng-modal-dialog' ng-style='dialogStyle'>" +
        "<div class='ng-modal-close' ng-click='hideModal()'>X</div>" +
        "<div class='ng-modal-dialog-content' ng-transclude></div>" +
        "</div>" +
        "</div>"
    };
});