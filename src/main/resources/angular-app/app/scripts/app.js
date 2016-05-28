'use strict';

/**
 * @ngdoc overview
 * @name healthmonApp
 * @description
 * # healthmonApp
 *
 * Main module of the application.
 */
angular
  .module('healthmonApp', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'cgBusy'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl',
        controllerAs: 'login'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .when('/signup', {
        templateUrl: 'views/signup.html',
        controller: 'SignupCtrl',
        controllerAs: 'signup'
      })
      .otherwise({
        redirectTo: '/'
      });
  }).config(["$provide", function ($provide) {
      $provide.value("apiRoot", $("#linkApiRoot").attr("href"));
}]).value('cgBusyDefaults',{
  message:'Please wait...',
  backdrop: false,
  delay: 0,
  minDuration: 300
});
