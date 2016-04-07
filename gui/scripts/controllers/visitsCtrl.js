var app = angular.module('clinicApp')
var clinicWS = "http://localhost:8080/SSK/";

app.controller('visitsCtrl', ['$scope', '$http', 'session', 'errorService',
    function ($scope, $http, session, errorService) {
        $scope.form = {};
        console.log(session.user);
        
        
        var retrieveVisits = function() {
            $http.get(clinicWS + "user/getVisits/" + session.user.id)
            .then(onGetVisits, onGetVisitsError);
        }
        
        retrieveVisits();
        
        var onGetVisits = function (response) {
            console.log(response);
            $scope.visit = response.data;
        }

        var onGetVisitsError = function (response) {
            errorService.logError("Failed in visitsCtrl: " + response.status);
        }

        $scope.addNewVisit = function () {
            $scope.newVisitForm = true;

        }

        $scope.newVisit = function () {
            var data = { userId: session.user.id, doctorId: session.user.user.id, dateFrom: $scope.form.dateFrom, dateTo: $scope.form.dateTo };
            $http.post(clinicWS + "/user/addVisit", data)
                .then(onVisitAdded);
        }
        
        $scope.getVisit = function() {
            retrieveVisits();
        }

        var onVisitAdded = function (response) {
            $scope.addedVisit = response.statusText;
            $scope.newVisitForm = false;
            retrieveVisits();
        }

    /**
     *
     * DATE FUNCTIONALITY 
     * 
     */
        $scope.today = function () {
            $scope.dt = new Date();
        };
        $scope.today();

        $scope.events = [
            {
                date: tomorrow,
                status: 'full'
            },
            {
                date: afterTomorrow,
                status: 'partially'
            }
        ];

        var tomorrow = new Date();
        tomorrow.setDate(tomorrow.getDate() + 1);
        var afterTomorrow = new Date(tomorrow);
        afterTomorrow.setDate(tomorrow.getDate() + 1);

        $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
        $scope.format = $scope.formats[0];
        $scope.altInputFormats = ['M!/d!/yyyy'];

        $scope.inlineOptions = {
            customClass: getDayClass,
            minDate: new Date(),
            showWeeks: true
        };

        function getDayClass(data) {
            var date = data.date,
                mode = data.mode;
            if (mode === 'day') {
                var dayToCheck = new Date(date).setHours(0, 0, 0, 0);

                for (var i = 0; i < $scope.events.length; i++) {
                    var currentDay = new Date($scope.events[i].date).setHours(0, 0, 0, 0);

                    if (dayToCheck === currentDay) {
                        return $scope.events[i].status;
                    }
                }
            }

            return '';
        }


    }]);    
