'use strict';

/**
 * ProfileController
 * @constructor
 */
var ProfileController = function ($scope, $http) {

    $scope.alerts = [];
    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };

    $scope.fetchCurrentUser = function () {
        $http.get('teacher/getCurrentUser').success(function (result) {
            $scope.profile = result;
        });
    };

    $scope.fetchCurrentUser();

    $scope.changePassword = function () {
        $scope.tempPassword = $scope.profile.password;
    };

    $scope.save = function () {
        $http.post('teacher/save', $scope.profile).success(function () {
            $scope.alerts.push({ type: 'success', msg: 'Пароль успешно изменен.'});
            $scope.tempPassword = undefined;
        });
    };

    $scope.cancelPassword = function () {
        $scope.profile.password = $scope.tempPassword;
        $scope.tempPassword = undefined;
    };
};