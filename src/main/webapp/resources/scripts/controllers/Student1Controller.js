/**
 * Student1Controller
 * @constructor
 */
var Student1Controller = function ($scope, $http, $modal) {

    $scope.label = "Студенты: 1 уровень подготовки";
    $scope.pageNumber = 1;
    $scope.faculty = '';
    $scope.group = '';
    $scope.totalCount = 0;
    $scope.perPage = 10;
    $scope.alerts = [];
    $scope.showReserve = false;
    $scope.showPromote = true;

    $scope.closeAlert = function(index) {
        $scope.alerts.splice(index, 1);
    };

    $scope.readStudents = function (page) {
        var options = {page: page, faculty: $scope.faculty, group: $scope.group};
        $http.post('student1/getList', options).success(function (result) {
            $scope.students = result.data;
            $scope.totalCount = result.totalCount;
        })
    };

    $scope.readGroups = function () {
        $http.get('group/getAll?select=true').success(function (response) {
            $scope.groups=response;
        })
    };

    $scope.readStudents($scope.pageNumber);
    $scope.readGroups();

    $scope.archive = function (student) {
        $http.delete('student1/archive', {data: student._id}).success(function () {
            $scope.readStudents($scope.pageNumber);
            $scope.alerts.push({ type: 'success', msg: 'Данные о студенте перенесены в архив.'});
        });
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
                    $scope.readStudents($scope.pageNumber);
                    $scope.alerts.push({ type: 'success', msg: 'Студент зачислен на второй курс.'});
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
