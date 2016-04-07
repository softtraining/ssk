var app = angular.module('clinicApp')
var clinicWS = "http://localhost:8080/SSK/";

app.controller('patientsCtrl', ['$scope', 'errorService', '$http', 'session',
    function ($scope, errorService, $http, session) {


        $scope.showAllPatientsForDoctor = function()
        {
            $http.get(clinicWS + "user/getPatients/" + session.user.id).then(onGet, onGetError);
        }

        var onGet = function(response)
        {
            console.log(response);
            $scope.patients = response.data;
        }
        
        var onGetError = function()
        {
            errorService.logError("getting patients error");
        }
        
    }]);
