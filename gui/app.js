var app = angular.module('clinicApp', ["ui.router", "ngResource", "ui.bootstrap"]);
   
// ***
// Routing
// ***

app
    .config(function ($stateProvider, $urlRouterProvider, $httpProvider) {

        $httpProvider.defaults.withCredentials = true;

        $urlRouterProvider.otherwise("/404");

        // for error handling
        $stateProvider
            .state('error', {
                abstract: true,
                template: "<ui-view/>",
                data: {
                    access: "*"
                }
            })
            .state('error.404', {
                url: '/404',
                templateUrl: 'templates/404.html'
            })
            .state('error.403', {
                url: '/403',
                templateUrl: 'templates/403.html'
            })
            .state('error.401', {
                url: '/401',
                templateUrl: 'templates/401.html'
            })

        // for unauthorized users
        $stateProvider
            .state('all', {
                abstract: true,
                template: "<ui-view/>",
                data: {
                    access: "*"
                }
            })
            .state('all.login', {
                url: '/login',
                templateUrl: 'templates/login.html',
                controller: 'sessionCtrl'
            })
            .state('all.home', {
                url: '/',
                templateUrl: 'templates/home.html',
            });
        
        // for authorized users
        $stateProvider
            .state('user', {
                abstract: true,
                template: "<ui-view/>",
                data:
                {
                    access: "user"
                }
            })
            .state('user.dashboard',
                {
                    url: "/dashboard",
                    templateUrl: "templates/dashboard.html",
                })
            .state('user.visits',
                {
                    url: "/visits",
                    templateUrl: "templates/visits.html",
                    controller: 'visitsCtrl'
                }
                )
        // for higher access - rights users
            .state('user.doctors',
                {
                    url: "/doctors",
                    templateUrl: "templates/doctors.html",
                    controller: 'doctorsCtrl',
                    data:
                    {
                        access: "admin"
                    }
                })
            .state('user.patients',
                {
                    url: "/patients",
                    templateUrl: "templates/patients.html",
                    controller: 'patientsCtrl',
                    data:
                    {
                        access: "doctor"
                    }
                })

    });

app
    .run(function ($rootScope, $state, Auth) {

        $rootScope.$on("$stateChangeStart",
            function (event, toState, toParams,
                fromState, fromParams) {
                console.log(fromState.name + " >>>>>> " + toState.name);

                if (toState.data.access != "*") {

                    if (!Auth.isAuthenticated()) {
                        $rootScope.error = null;
                        $state.go('all.login');
                        $rootScope.error = "Access denied";
                        console.log("Access denied");
                    }
                }
            });
    })

