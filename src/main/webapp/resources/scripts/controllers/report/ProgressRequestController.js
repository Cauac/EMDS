/**
 * ProgressRequestController
 * @constructor
 */
var ProgressRequestController = function ($scope, $http) {

    $scope.generateReport = function () {
        $http.post('report/progressRequest', $scope.faculty).success(function (fileCode) {
            var evt = document.createEvent('MouseEvents');
            evt.initMouseEvent('click', true, true, window, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
            var element = document.getElementById('download');
            element.href = 'report/get?fileCode=' + fileCode;
            element.dispatchEvent(evt);
        });
    };
};
