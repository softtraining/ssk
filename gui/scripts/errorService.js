var app = angular.module('clinicApp');

app
    .factory('errorService', ['$rootScope',
        function ($rootScope) {
            var service = {};
            service.logError = function (error)
            {
                console.log(error);
            }
            
            return service;          
        }]);