/**
 * AllowedListController
 * @constructor
 */
var AllowedListController = function ($scope, $http) {

    $scope.readGroups = function () {
        $http.get('group/getAll?select=true').success(function (response) {
            $scope.groups = response;
        });
    };

    $scope.generateReport = function () {
        $http.post('report/allowedList', $scope.groupId).success(function (fileCode) {
            var evt = document.createEvent('MouseEvents');
            evt.initMouseEvent('click', true, true, window, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
            var element = document.getElementById('download');
            element.href = 'report/get?fileCode=' + fileCode;
            element.dispatchEvent(evt);
        });
    };

    $scope.readGroups();
};
