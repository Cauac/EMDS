'use strict';

/**
 * AbiturientController
 * @constructor
 */
var AbiturientController = function ($scope, $http, $modal) {

    $scope.pageNumber = 1;
    $scope.faculty = '';
    $scope.totalCount = 0;
    $scope.perPage = 6;

    $scope.readAbiturients = function (page) {
        var options = {page: page, faculty: $scope.faculty};
        $http.post('abiturient/getAll', options).success(function (result) {
            $scope.totalCount = result.totalCount;
            $scope.students = result.data;
        })
    };

    $scope.readAbiturients(1);

    $scope.archiveStudent = function (student) {
        $http.delete('abiturient/archive', {data: student._id}).success(function () {
            $scope.readAbiturients($scope.pageNumber);
        });
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
                if ($scope.perPage > ($scope.students.length)) {
                    $scope.students.push(response);
                }
                $scope.totalCount = $scope.totalCount + 1;
            });
        });
    };

    $scope.documentExist = function (student, documentName) {
        return student.document && student.document[documentName];
    };

    $scope.readyStudentialize = function (student) {
        return student.document && Object.keys(student.document).length == 7 && student.questionnaire;
    };

    $scope.studentialize = function (student) {
        $http.get('group/getAll').success(function (groups) {
            var modalInstance = $modal.open({
                templateUrl: 'resources/html/abiturient/studentialize.html',
                controller: StudentializeDialog,
                resolve: {
                    student: function () {
                        return student;
                    },
                    groups: function () {
                        return groups;
                    }
                }
            });
            modalInstance.result.then(function (result) {
                $http.post("abiturient/studentialize", {id: student._id, group_id: result}).success(function () {
                    $scope.readAbiturients($scope.pageNumber);
                });
            });
        });
    };

    $scope.document = function (student, documentType) {
        var modalInstance = $modal.open({
            templateUrl: 'resources/html/abiturient/document/' + documentType + '.html',
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

    $scope.questionnaire = function (student) {
        var modalInstance = $modal.open({
            templateUrl: 'resources/html/abiturient/document/questionnaire.html',
            controller: QuestionnaireDialog,
            resolve: {
                student: function () {
                    return student;
                }
            }
        });

        modalInstance.result.then(function (result) {
            $http.post('abiturient/saveQuestionnaire', result);
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
    $scope.document = {};
    if (student.document && student.document[documentType]) {
        CommonService.copyAttr(student.document[documentType], $scope.document);
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

var QuestionnaireDialog = function ($scope, $modalInstance, student, CommonService) {

    $scope.student = student;
    $scope.questionnaire = {};
    $scope.pageNumber = 1;
    if (student.questionnaire) {
        CommonService.copyAttr(student.questionnaire, $scope.questionnaire);
    }

    $scope.ok = function () {
        $scope.student['questionnaire'] = $scope.questionnaire;
        $modalInstance.close({id: $scope.student._id, data: $scope.questionnaire});
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};

var StudentializeDialog = function ($scope, $modalInstance, student, groups) {
    $scope.groups = groups;
    $scope.student = student;
    $scope.selected = {};
    $scope.ok = function (group) {
        $modalInstance.close(group);
    };
    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};

