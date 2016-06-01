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
    'cgBusy',
    'ab-base64',
    'chart.js',
    'ui.select',
    'ui.bootstrap'
  ])
  .config(function ($routeProvider, $httpProvider) {
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
      .when('/dashboard', {
        templateUrl: 'views/dashboard.html',
        controller: 'DashboardCtrl',
        controllerAs: 'dashboard'
      })
      .otherwise({
        redirectTo: '/'
      });
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
  }).config(['$httpProvider', function ($httpProvider) {
    $httpProvider.defaults.withCredentials = true;
  }]).config(['$provide', function ($provide) {
    $provide.value('apiRoot', angular.element(document.querySelector('#linkApiRoot')).attr('href'));
  }]).value('cgBusyDefaults', {
    message: 'Please wait...',
    backdrop: false,
    delay: 0,
    minDuration: 300
  }).run(function ($rootScope, $location, User) {

    String.prototype.endsWith = function(suffix) {
      return this.indexOf(suffix, this.length - suffix.length) !== -1;
    };
    $rootScope.$on('$locationChangeStart', function (event, next) {
      if ($rootScope.authenticatedUser === undefined) {
        User.get({id: 'me'}, function (response) {
          $rootScope.authenticatedUser = response.principal;
        }, function () {
          if (next.endsWith('/') || next.endsWith('signup')) {
          } else {
            $location.path('/');
          }
        });
      } else {
      }
    });
});
