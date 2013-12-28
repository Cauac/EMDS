'use strict';

/**
 * SpecialtyController
 * @constructor
 */
var SpecialtyController = function ($scope, $http, $modal, CommonService) {

    $scope.readSpecialties = function () {
        $http.get('specialty/getAll').success(function (response) {
            $scope.specialties = response;
        })
    };

    $scope.removeSpecialty = function (specialty) {
        $http.delete('specialty/delete?id=' + specialty._id);
        var index = $scope.specialties.indexOf(specialty);
        $scope.specialties.splice(index, 1);
    };

    $scope.editSpecialty = function (specialty) {
        var modalInstance = $modal.open({
            templateUrl: 'resources/html/specialty/edit.html',
            controller: EditSpecialtyDialog,
            resolve: {
                specialty: function () {
                    return specialty;
                }
            }
        });

        modalInstance.result.then(function (result) {
            $http.post('specialty/update', result);
        });
    };

    $scope.addSpecialty = function () {
        var modalInstance = $modal.open({
            templateUrl: 'resources/html/specialty/edit.html',
            controller: AddSpecialtyDialog
        });

        modalInstance.result.then(function (result) {
            $http.post('specialty/save', result);
            $scope.specialties.push(result);
        });
    };

    $scope.readSpecialties();
    CommonService.setTitle('Специальности')
};

var AddSpecialtyDialog = function ($scope, $modalInstance) {

    $scope.specialty = {_id: '', description: ''};

    $scope.ok = function () {
        $modalInstance.close($scope.specialty);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};


var EditSpecialtyDialog = function ($scope, $modalInstance, specialty, CommonService) {

    $scope.specialty = {};
    CommonService.copyAttr(specialty, $scope.specialty);

    $scope.ok = function () {
        var identity = specialty._id;
        CommonService.copyAttr($scope.specialty, specialty);
        $modalInstance.close($scope.specialty);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};
