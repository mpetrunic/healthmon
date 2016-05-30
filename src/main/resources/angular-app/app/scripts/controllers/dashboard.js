'use strict';

/**
 * @ngdoc function
 * @name healthmonApp.controller:DashboardCtrl
 * @description
 * # DashboardCtrl
 * Controller of the healthmonApp
 */
angular.module('healthmonApp')
  .controller('DashboardCtrl', function ($rootScope, apiRoot, $location, $http) {
    var self = this;
    self.user = $rootScope.authenticatedUser;
    $rootScope.$watch('authenticatedUser', function() {
      self.user = $rootScope.authenticatedUser;
    });

    function logout() {
      $http.get(apiRoot+'/logout');
      $rootScope.authenticatedUser = undefined;
      $location.path('/');
    }

    this.logout = logout;
  });
