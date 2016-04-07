var app = angular.module('clinicApp');

app.service('session', function ($rootScope) {

    var service = {};
    service.user = {};
    
    service.create = function (user) {
        service.user = user;
        $rootScope.user = user;
        if(user.firstName == "Damian")
        {
            $rootScope.user.admin = true;
        }
    };

    service.destroy = function () {
        service.user = null;
        $rootScope.user = null;
    };
    return service;
});