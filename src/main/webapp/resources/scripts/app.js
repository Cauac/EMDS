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

    $routeProvider.when('/groups', {
        templateUrl: 'resources/html/group/list.html',
        controller: GroupController
    });

    $routeProvider.otherwise({redirectTo: '/teachers'});

}]);

App.factory("CommonService", function () {
    return {
        copyAttr: function (from, to) {
            for (var attr in from) {
                to[attr] = from[attr];
            }
        }
    }
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

App.directive('activeLink', ['$location', function(location) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var path = attrs.activeLink;
            scope.location = location;
            scope.$watch('location.path()', function(newPath) {
                if (path === newPath.substring(1)) {
                    element.addClass('active');
                } else {
                    element.removeClass('active');
                }
            });
        }

    };
}]);

App.directive('subMenu', [ function() {
    return {
        restrict: 'A',
        link: function(scope, element) {
            element.bind('click', function () {
                if(element.hasClass('open')){
                    element.removeClass('open');
                }else{
                    element.addClass('open');
                }
            });
        }

    };
}]);


