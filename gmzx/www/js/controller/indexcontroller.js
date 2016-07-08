var indexApp1= angular.module('indexApp', ['ngRoute']);
indexApp1.config(function($routeProvider){

    $routeProvider
        .when('/',{
            templateUrl:'templates/productlist.html'
        })

        .when('/nose',{

            templateUrl:'templates/productlist2.html'

        })

        .otherwise({redirectTo:'/'});

    console.log('App called.');
});