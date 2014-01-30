/**
 * PersonCardController
 * @constructor
 */
var PersonCardController = function ($scope, $http) {

    $scope.printPhoto = true;

    $scope.readGroups = function () {
        $http.get('group/getAll').success(function (response) {
            $scope.groups = response;
        });
    };

    $scope.readStudents = function (group) {
        $http.post('group/getStudents', group).success(function (response) {
            $scope.students = response;
        });
    };

    $scope.generateReport = function () {
        if ($scope.student) {
            $http.post('report/personCard?studentId=' + $scope.student + '&printPhoto=' + $scope.printPhoto).success(function (fileCode) {
                var evt = document.createEvent('MouseEvents');
                evt.initMouseEvent('click', true, true, window, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                var element = document.getElementById('download');
                element.href = 'report/get?fileCode=' + fileCode;
                element.dispatchEvent(evt);
            });
        }
    };

    $scope.readGroups();
};
