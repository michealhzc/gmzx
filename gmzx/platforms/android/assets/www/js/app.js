/**
 * Created by shollin on 2016-07-07.
 */

(function(angular){


var app = angular.module('gmzxApp', ['ui.router',
    'ngCordova',
    'gmzxApp.user',
    'gmzxApp.cms',
    'gmzxApp.shop'
]);


app.config(function($stateProvider, $urlRouterProvider){
        $urlRouterProvider.otherwise('/');
        $stateProvider
            .state('index',{
                url: '/',
                views: {

                    'content': {
                        templateUrl: './templates/cms/index.html',
                        controller: 'cmsCtrl'
                    },
                    'footer': {
                        templateUrl: './templates/common/footer.html'
                    }
                }
            })
            .state('user', {
                url: '/user',
                views: {
                    'content@': {
                        templateUrl: './templates/user/index.html',
                        controller: 'userCtrl'
                    },
                    'header': {
                        templateUrl:'./templates/common/header.html'
                    },
                    'footer': {
                        templateUrl:'./templates/common/footer.html'
                    }
                }
            })
            .state('shop', {
                url: '/shop',
                views: {
                    'header': {
                        templateUrl:'./templates/common/header.html'
                    },
                    'content': {
                        templateUrl:'./templates/shop/index.html',
                        controller: 'shopCtrl'
                    },
                    'footer': {
                        templateUrl: './templates/common/footer.html'
                    }
                }
            })
    });


})(angular);