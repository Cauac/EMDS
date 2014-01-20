'use strict';

/**
 * ArchiveController
 * @constructor
 */
var ArchiveController = function ($scope, $http, $modal) {


    $scope.readAll = function () {
        $http.get('archive/getAll').success(function (response) {
            $scope.students = response;
        })
    };

    $scope.readAll();

    $scope.delete = function (student) {
        $http.delete('archive/delete', {data: student._id});
        var index = $scope.students.indexOf(student);
        $scope.students.splice(index, 1);
    };

    $scope.edit = function (student) {
        var modalInstance = $modal.open({
            templateUrl: 'resources/html/student/edit.html',
            controller: EditStudentDialog,
            resolve: {
                student: function () {
                    return student;
                }
            }
        });

        modalInstance.result.then(function (result) {
            $http.post('archive/save', result);
        });
    };
};

var EditStudentDialog = function ($scope, $modalInstance, $http, student, CommonService) {

    $scope.student = {};
    $scope.pageNumber = 1;
    CommonService.copyAttr(student, $scope.student);

    $scope.ok = function () {
        CommonService.copyAttr($scope.student, student);
        $modalInstance.close($scope.student);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};