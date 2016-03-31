var app = angular.module('clinicApp')

app.controller('sessionCtrl', ['$scope', '$rootScope', 'errorService', 'Auth',
    function ($scope, $rootScope, errorService, Auth) {
        $scope.form = {};
        $rootScope.loginError = false;
        $scope.login = function () {
            if ($scope.form.login != null && $scope.form.password != null) {
                Auth.login($scope.form.login, $scope.form.password);
            }
            else {
                errorService.logError("sessionCtrl -> login or password is empty");
            }
        }
    }]);