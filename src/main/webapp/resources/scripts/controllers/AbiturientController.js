'use strict';

/**
 * AbiturientController
 * @constructor
 */
var AbiturientController = function ($scope, $http, $modal) {

    $scope.readAbiturients = function () {
        $http.get('abiturient/getAll').success(function (response) {
            $scope.students = response;
        })
    };

    $scope.removeStudent = function (student) {
        $http.delete('abiturient/delete', {data: student._id});
        var index = $scope.students.indexOf(student);
        $scope.students.splice(index, 1);
    };

    $scope.editStudent = function (student) {
        var modalInstance = $modal.open({
            templateUrl: 'resources/html/abiturient/edit.html',
            controller: EditStudentDialog,
            resolve: {
                student: function () {
                    return student;
                }
            }
        });

        modalInstance.result.then(function (result) {
            $http.post('abiturient/save', result);
        });
    };

    $scope.addStudent = function () {
        var modalInstance = $modal.open({
            templateUrl: 'resources/html/abiturient/edit.html',
            controller: AddStudentDialog
        });

        modalInstance.result.then(function (result) {
            $http.post('abiturient/save', result).success(function (response) {
                $scope.students.push(response);
            });
        });
    };

    $scope.readAbiturients();

    $scope.documentExist = function (student, documentName) {
        return student.document && student.document[documentName];
    };

    $scope.readyStudentialize = function (student) {
        return student.document&&Object.keys(student.document).length == 8;
    }

    $scope.document = function (student, documentType) {
        var modalInstance = $modal.open({
            templateUrl: 'resources/html/document/' + documentType + '.html',
            controller: DocumentDialog,
            resolve: {
                student: function () {
                    return student;
                },
                documentType: function () {
                    return documentType;
                }
            }
        });

        modalInstance.result.then(function (result) {
            $http.post('abiturient/saveDocument', result);
        });
    };
};

var AddStudentDialog = function ($scope, $modalInstance) {

    $scope.student = {last_name: '', first_name: '', middle_name: '', faculty: ''};

    $scope.ok = function () {
        $modalInstance.close($scope.student);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};

var EditStudentDialog = function ($scope, $modalInstance, $http, student, CommonService) {

    $scope.student = {};
    CommonService.copyAttr(student, $scope.student);

    $scope.ok = function () {
        CommonService.copyAttr($scope.student, student);
        $modalInstance.close($scope.student);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};

var DocumentDialog = function ($scope, $modalInstance, student, documentType, CommonService) {

    $scope.student = student;
    if (student.document && student.document[documentType]) {
        $scope.document = {commentary: student.document[documentType].commentary};
    } else {
        $scope.document = {commentary: 'Дата подачи : ' + CommonService.currentDate()};
    }

    $scope.ok = function () {
        if (!$scope.student.document) {
            $scope.student.document = {};
        }
        $scope.student.document[documentType] = $scope.document;
        $modalInstance.close({id: $scope.student._id, documentType: documentType, data: $scope.document});
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};

