/**
 * Student1Controller
 * @constructor
 */
var Student1Controller = function ($scope, $http, $modal) {

    $scope.label = "Студенты: 1 уровень подготовки";

    $scope.readAll = function () {
        $http.get('student1/getAll').success(function (response) {
            $scope.students = response;
        })
    };

    $scope.readAll();

    $scope.archive = function (student) {
        $http.delete('student1/archive', {data: student._id});
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
            $http.post('student1/save', result);
        });
    };

    $scope.promote = function (student) {
        $http.get('group/getAll').success(function (groups) {
            var modalInstance = $modal.open({
                templateUrl: 'resources/html/student/promote1.html',
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
                $http.post("student1/promote", {id: student._id, group_id: result}).success(function () {
                    var index = $scope.students.indexOf(student);
                    $scope.students.splice(index, 1);
                });
            });
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
