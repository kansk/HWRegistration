var registrationControllers = angular.module('registrationControllers', []);

registrationControllers.controller('RegistrationCtrl', ['$scope', '$q', 'registrationService',
    function($scope, $q, registrationService) {

        $scope.registration = {};

        $scope.saveRegistration = function(registration) {
            console.log($scope.registration);
            registrationService.save($scope.registration).then(function(data) {
                console.debug("Registration Saved")
            });
        }
    }]);