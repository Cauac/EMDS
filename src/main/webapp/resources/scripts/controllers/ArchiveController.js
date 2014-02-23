'use strict';

/**
 * ArchiveController
 * @constructor
 */
var ArchiveController = function ($scope, $http, $modal) {

    $scope.pageNumber = 1;
    $scope.faculty = '';
    $scope.status = '';
    $scope.totalCount = 0;
    $scope.perPage = 10;
    $scope.alerts = [];

    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };

    $scope.readStudents = function (page) {
        var options = {page: page, faculty: $scope.faculty, status: $scope.status};
        $http.post('archive/getList', options).success(function (result) {
            $scope.students = result.data;
            $scope.totalCount = result.totalCount;
        })
    };

    $scope.readStudents(1);

    $scope.delete = function (student) {
        $http.delete('archive/delete', {data: student._id});
        $scope.readStudents($scope.pageNumber);
        $scope.alerts.push({ type: 'success', msg: 'Данные о студенте успешно удалены.'});
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