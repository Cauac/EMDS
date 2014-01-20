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

    $routeProvider.when('/abiturient', {
        templateUrl: 'resources/html/abiturient/list.html',
        controller: AbiturientController
    });

    $routeProvider.when('/archive', {
        templateUrl: 'resources/html/archive/list.html',
        controller: ArchiveController
    });

    $routeProvider.otherwise({redirectTo: '/teachers'});

}]);

App.factory("CommonService", function ($filter) {
    return {
        copyAttr: function (from, to) {
            for (var attr in from) {
                to[attr] = from[attr];
            }
        },
        currentDate:function(){
            return $filter('date')(Date.now(),'dd.MM.yyyy');
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

App.directive('activeLink', ['$location', function (location) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var path = attrs.activeLink;
            scope.location = location;
            scope.$watch('location.path()', function (newPath) {
                if (path === newPath.substring(1)) {
                    element.addClass('active');
                } else {
                    element.removeClass('active');
                }
            });
        }

    };
}]);

App.directive('subMenu', [ function () {
    return {
        restrict: 'A',
        link: function (scope, element) {
            element.bind('click', function () {
                var parent=element.parent();
                if (parent.hasClass('open')) {
                    parent.removeClass('open');
                } else {
                    parent.addClass('open');
                }
            });
        }

    };
}]);


