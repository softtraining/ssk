var app = angular.module('clinicApp')
var clinicWS = "http://localhost:8080/SSK/";

app.controller('doctorsCtrl', ['$scope', 'errorService', '$http',
    function ($scope, errorService, $http) {


        $scope.showAllDoctors = function()
        {
            $http.get(clinicWS + "user/getDoctors").then(onGetDoctors, onGetDoctorsError);
        }

        var onGetDoctors = function(response)
        {
            console.log(response);
            $scope.doctors = response.data;
        }
        
        var onGetDoctorsError = function()
        {
            errorService.logError("getting doctors error");
        }
        
    }]);
