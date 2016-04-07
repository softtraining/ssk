var app = angular.module('clinicApp');

app.service('session', function ($rootScope) {
    this.user = {};
    
    this.create = function (user) {
        this.user = user;
        $rootScope.user = user;
        if(user.firstName == "User")
        {
            $rootScope.user.admin = true;
        }
    };

    this.destroy = function () {
        this.user = null;
        $rootScope.user = null;
    };
});