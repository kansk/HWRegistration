var registrationControllers = angular.module('registrationControllers', []);

registrationControllers.controller('RegistrationCtrl', ['$scope', '$q', 'registrationService',
    function ($scope, $q, registrationService) {

        $scope.registration = {};

        $scope.modalShown = false;
        $scope.toggleModal = function () {
            $scope.modalShown = !$scope.modalShown;
        };

        $scope.saveRegistration = function (registration) {
            $scope.errors = {};
            console.log($scope.registration);
            registrationService.save($scope.registration).then(function (success) {
                console.debug("Registration Saved")
            }, function (error) {
                //console.log(error);
                $scope.errors.api = error.data.errors[0].code;
            });
            $scope.modalShown = false;
        };

    }]);