var clinicWS = "http://localhost:8080/SSK/";
var app = angular.module('clinicApp');

app
    .factory("Auth", ['$http', '$state', '$rootScope', '$window', 'errorService', 'session',
        function ($http, $state, $rootScope, $window, errorService, session) {
            var service = {};

            service.login = function (code, isDoctor) {
                if (code != null) {
                    $http.get(clinicWS + "auth/" + code + "/" + isDoctor)
                        .then(onLogin, onLoginError);
                }
                else {
                    errorService.logError("authService -> login(): parameters are empty");
                }
            }

            var onLogin = function (response) {
                session.create(response.data);
                $state.go('user.dashboard');
            }

            var onLoginError = function () {
                errorService.logError("authService -> login() error, authentication failed when connecting to WS");
            }

            service.logout = function () {
                session.destroy();
                $state.go('all.login');
            }

            service.isAuthorized = function (access) {
                if (access != "*") {
                    return true;
                }
                return false;
            }

            service.isAuthenticated = function () {
                return session.user != null;
            }

            return service;
        }
    ]);
