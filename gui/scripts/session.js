var app = angular.module('clinicApp');

app.service('session', function ($rootScope) {

    var service = {};
    service.user = {};
    
    service.create = function (user) {
        service.user = user;
        $rootScope.user = user;
    };

    service.destroy = function () {
        service.user = null;
        $rootScope.user = null;
    };
    return service;
});