var reportControllers = angular.module('reportControllers', []);

reportControllers.controller('ReportCtrl', ['$scope', '$q', 'reportService', 'DTOptionsBuilder', 'DTColumnDefBuilder',
    function($scope, $q, reportService, DTOptionsBuilder, DTColumnDefBuilder) {

        var vm = this;
        vm.dtOptions = DTOptionsBuilder.newOptions()
            .withPaginationType('full_numbers')
            .withDisplayLength(2)
            .withDOM('pitrfl');
        vm.dtColumnDefs = [
            DTColumnDefBuilder.newColumnDef(0),
            DTColumnDefBuilder.newColumnDef(1).notVisible(),
            DTColumnDefBuilder.newColumnDef(2).notSortable()
        ];

        reportService.getReport().then(function(response) {
            $scope.registrations = response.data;
        });

    }]);

