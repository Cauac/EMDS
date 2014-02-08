/**
 * ExamProtocolController
 * @constructor
 */
var ExamProtocolController = function ($scope, $http) {

    $scope.readGroups = function () {
        $http.get('group/getAll?select=true').success(function (response) {
            $scope.groups = response;
        });
    };

    $scope.readTeacherList = function () {
        $http.get('teacher/getAll').success(function (list) {
            $scope.teachers = list;
        })
    };

    $scope.generateReport = function () {
        var data = {group: $scope.groupId, members: $scope.members};
        $http.post('report/examProtocol', data).success(function (fileCode) {
            var evt = document.createEvent('MouseEvents');
            evt.initMouseEvent('click', true, true, window, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
            var element = document.getElementById('download');
            element.href = 'report/get?fileCode=' + fileCode;
            element.dispatchEvent(evt);
        });
    };

    $scope.readGroups();
    $scope.readTeacherList();
};
