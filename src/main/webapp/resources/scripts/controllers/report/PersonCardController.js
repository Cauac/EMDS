/**
 * PersonCardController
 * @constructor
 */
var PersonCardController = function ($scope, $http) {
    $scope.group;
    $scope.student;
    $scope.printPhoto = true;

    $scope.readGroups = function () {
        $http.get('group/getAll').success(function (response) {
            $scope.groups = response;
        });
    };

    $scope.readStudents = function () {
        $http.get('group/getStudents').success(function (response) {
            $scope.groups = response;
        });
    }

    $scope.readGroups();
};
