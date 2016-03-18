var app = angular.module('clinicApp')

app.controller('sessionCtrl', ['$scope', 'errorService', 'Auth',
    function ($scope, errorService, Auth) {
        $scope.form = {};
        $scope.form.isDoctor = false;

        $scope.login = function () {
            if ($scope.form.userCode != null) {
                Auth.login($scope.form.userCode, $scope.form.isDoctor);
            }
            else {
                errorService.logError("sessionCtrl -> user code is empty");
            }
        }
    }]);