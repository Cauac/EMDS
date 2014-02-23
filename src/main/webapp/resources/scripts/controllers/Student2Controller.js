/**
 * Student2Controller
 * @constructor
 */
var Student2Controller = function ($scope, $http, $modal) {

    $scope.label = "Студенты: 2 уровень подготовки";
    $scope.pageNumber = 1;
    $scope.faculty = '';
    $scope.group = '';
    $scope.totalCount = 0;
    $scope.perPage = 10;
    $scope.alerts = [];
    $scope.showReserve = true;
    $scope.showPromote = false;

    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };

    $scope.readStudents = function (page) {
        var options = {page: page, faculty: $scope.faculty, group: $scope.group};
        $http.post('student2/getList', options).success(function (result) {
            $scope.students = result.data;
            $scope.totalCount = result.totalCount;
        })
    };

    $scope.readGroups = function () {
        $http.get('group/getAll?select=true').success(function (response) {
            $scope.groups = response;
        })
    };

    $scope.readStudents(1);
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
            $http.post('student2/save', result);
        });
    };

    $scope.promote = function (student) {
        $http.post("student2/reserve", student._id).success(function () {
            $scope.readStudents($scope.pageNumber);
            $scope.alerts.push({ type: 'success', msg: 'Данные о студенте перенесены в архив.'});
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

