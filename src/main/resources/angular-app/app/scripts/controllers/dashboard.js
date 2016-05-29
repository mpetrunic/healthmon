'use strict';

/**
 * @ngdoc function
 * @name healthmonApp.controller:DashboardCtrl
 * @description
 * # DashboardCtrl
 * Controller of the healthmonApp
 */
angular.module('healthmonApp')
  .controller('DashboardCtrl', function ($rootScope) {
    var self = this;
    self.user = $rootScope.authenticatedUser;
    $rootScope.$watch('authenticatedUser', function() {
      self.user = $rootScope.authenticatedUser;
    });
  });
