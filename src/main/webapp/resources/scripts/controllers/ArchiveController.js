'use strict';

/**
 * ArchiveController
 * @constructor
 */
var ArchiveController = function ($scope, $http) {


    $scope.readArchive = function () {
        $http.get('archive/getAll').success(function (response) {
            $scope.students = response;
        })
    };

    $scope.readArchive();

    $scope.removeStudent = function (student) {
        $http.delete('archive/delete', {data: student._id});
        var index = $scope.students.indexOf(student);
        $scope.students.splice(index, 1);
    };
};