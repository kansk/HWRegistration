var confirmationControllers = angular.module('confirmationControllers', []);

confirmationControllers.controller('ConfirmationCtrl', ['$scope', '$q', 'registrationService',
    function ($scope, $q, registrationService) {
        $scope.registration = registrationService.getCurrentRegistration();
    }]);