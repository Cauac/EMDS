'use strict';

/**
 * GroupController
 * @constructor
 */
var GroupController = function ($scope, $http, $modal) {

    $scope.readGroups = function () {
        $http.get('group/getAll').success(function (response) {
            $scope.groups = response;
        })
    };

    $scope.removeGroup = function (group) {
        $http.delete('group/delete', {data: group._id});
        var index = $scope.groups.indexOf(group);
        $scope.groups.splice(index, 1);
    };

    $scope.editGroup = function (group) {
        var modalInstance = $modal.open({
            templateUrl: 'resources/html/group/edit.html',
            controller: EditGroupDialog,
            resolve: {
                group: function () {
                    return group;
                }
            }
        });

        modalInstance.result.then(function (result) {
            $http.post('group/update', result);
        });
    };

    $scope.addGroup = function () {
        var modalInstance = $modal.open({
            templateUrl: 'resources/html/group/edit.html',
            controller: AddGroupDialog
        });

        modalInstance.result.then(function (result) {
            $http.post('group/save', result);
            $scope.groups.push(result);
        });
    };

    $scope.readGroups();
};

var AddGroupDialog = function ($scope, $http, $modalInstance) {

    $scope.group = {_id: '', specialty: ''};

    $scope.init = function () {
        $http.get('specialty/getAll').success(function (response) {
            $scope.specialties = response;
        });
    };

    $scope.init();

    $scope.ok = function () {
        $modalInstance.close($scope.group);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};


var EditGroupDialog = function ($scope, $modalInstance, $http, group, CommonService) {

    $scope.group = {};
    CommonService.copyAttr(group, $scope.group);

    $scope.init = function () {
        $http.get('specialty/getAll').success(function (response) {
            $scope.specialties = response;
        });
    };

    $scope.init();

    $scope.ok = function () {
        var identity = group._id;
        CommonService.copyAttr($scope.group, group);
        $modalInstance.close({id: identity, data: $scope.group});
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};
