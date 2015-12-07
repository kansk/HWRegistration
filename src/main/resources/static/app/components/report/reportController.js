var reportControllers = angular.module('reportControllers', []);

reportControllers.controller('ReportCtrl', ['$scope', '$q', '$location', 'reportService', 'DTOptionsBuilder', 'DTColumnDefBuilder',
    function($scope, $q, $location, reportService, DTOptionsBuilder, DTColumnDefBuilder) {

        var vm = this;
        vm.dtOptions = DTOptionsBuilder.newOptions()
            .withPaginationType('full_numbers')
            .withDisplayLength(2)
            .withDOM('pitrfl')
            .withOption('order', [8, 'desc']);

        reportService.getReport().then(function(response) {
            $scope.registrations = response.data;
        });

        $scope.deleteRegistrations = function() {
            reportService.deleteRegistrations().then(function(success) {
                console.debug("Registrations Deleted");
                $location.path('/registration');
            });
        }

    }]);