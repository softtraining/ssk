var app = angular.module('clinicApp')

app.controller('mainCtrl', ['$scope', 'errorService', 'Auth',
    function ($scope, errorService, Auth) {

        $scope.logout = function () {
            Auth.logout();
        }
        
    }]);
