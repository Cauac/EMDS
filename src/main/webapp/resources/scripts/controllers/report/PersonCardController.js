/**
 * PersonCardController
 * @constructor
 */
var PersonCardController = function ($scope, $http, $window) {

    $scope.printPhoto = true;

    $scope.p=10;
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
            return $http.post('report/personCard',$scope.student).success(function (number) {
                $scope.reportNum=number;
            });
        }
    };

    $scope.readGroups();
};
