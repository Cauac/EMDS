'use strict';

var EMDS = {};

var App = angular.module('EMDS', ['EMDS.filters', 'EMDS.services', 'EMDS.directives', 'ui.bootstrap.modal']);

App.config(['$routeProvider', function ($routeProvider) {

    $routeProvider.when('/teachers', {
        templateUrl: 'resources/html/teacher/list.html',
        controller: TeacherController
    });

    $routeProvider.when('/specialties', {
        templateUrl: 'resources/html/specialty/list.html',
        controller: SpecialtyController
    });

    $routeProvider.otherwise({redirectTo: '/teachers'});

}]);

App.factory("CommonService", function () {
    var title = '';
    return {
        copyAttr: function (from, to) {
            for (var attr in from) {
                to[attr] = from[attr];
            }
        },
        title: function () {
            return title;
        },
        setTitle: function (newTitle) {
            title = newTitle
        }
    }
});

App.controller('CommonController', function ($scope, CommonService) {
    $scope.CommonService = CommonService;
});

App.directive('ngReallyClick', [function () {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            element.bind('click', function () {
                var message = attrs.ngReallyMessage;
                if (message && confirm(message)) {
                    scope.$apply(attrs.ngReallyClick);
                }
            });
        }
    }
}]);


