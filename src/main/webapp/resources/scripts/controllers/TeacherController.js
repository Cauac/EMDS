'use strict';

/**
 * TeacherController
 * @constructor
 */
var TeacherController = function ($scope, $http, $modal) {

    $scope.readTeacherList = function () {
        $http.get('teacher/getAll?sort=true').success(function (list) {
            $scope.teachers = list;
        })
    };

    $scope.readTeacherList();

    $scope.removeTeacher = function (teacher) {
        $http.delete('teacher/delete?id=' + teacher._id);
        var index = $scope.teachers.indexOf(teacher);
        $scope.teachers.splice(index, 1);
    };

    $scope.addTeacher = function () {
        var modalInstance = $modal.open({
            templateUrl: 'resources/html/teacher/edit.html',
            controller: AddTeacherDialog
        });

        modalInstance.result.then(function (result) {
            $http.post('teacher/save', result)
                .success(function (response) {
                    $scope.teachers.push(response);
                })
        });
    };

    $scope.editTeacher = function (teacher) {
        var modalInstance = $modal.open({
            templateUrl: 'resources/html/teacher/edit.html',
            controller: EditTeacherDialog,
            resolve: {
                teacher: function () {
                    return teacher;
                }
            }
        });

        modalInstance.result.then(function (result) {
            $http.post('teacher/save', result);
        });
    };

    $scope.setChief = function (teacher) {
        for (var i = 0; i < $scope.teachers.length; i++) {
            $scope.teachers[i].is_chief = false;
        }
        teacher.is_chief = true;
        $http.post('teacher/chooseChief?id=' + teacher._id);
    };
};


var EditTeacherDialog = function ($scope, $modalInstance, CommonService, teacher) {

    $scope.teacher = {};
    CommonService.copyAttr(teacher, $scope.teacher);

    $scope.ok = function () {
        CommonService.copyAttr($scope.teacher, teacher);
        $modalInstance.close(teacher);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel')
    };
};

var AddTeacherDialog = function ($scope, $modalInstance) {

    $scope.teacher = {last_name: '', first_name: '', middle_name: '', rank: ''};

    $scope.ok = function () {
        $modalInstance.close($scope.teacher);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel')
    };
};