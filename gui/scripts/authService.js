var clinicWS = "http://localhost:8080/SSK/";
var app = angular.module('clinicApp');

app
    .factory("Auth", ['$http', '$state', '$rootScope', '$window', 'errorService', 'session',
        function ($http, $state, $rootScope, $window, errorService, session) {
            var service = {};
            $http.defaults.useXDomain = true;
            $rootScope.loginError = false;
                    
            service.login = function (loginJ, passwordJ) {
                if (loginJ != null && passwordJ != null) {
                    var data = {
                        login: loginJ,
                        password: passwordJ
                    }
                    $http.post(clinicWS + "auth/login", data)
                        .then(onLogin, onLoginError);
                }
                else {
                    $rootScope.loginError = true;
                    errorService.logError("authService -> login(): parameters are empty");
                }
            }

            var onLogin = function (response) {
                session.create(response.data);
                $state.go('user.dashboard');
            }

            var onLoginError = function () {
                $rootScope.loginError = true;
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
