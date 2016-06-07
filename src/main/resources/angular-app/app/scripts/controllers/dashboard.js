'use strict';

/**
 * @ngdoc function
 * @name healthmonApp.controller:DashboardCtrl
 * @description
 * # DashboardCtrl
 * Controller of the healthmonApp
 */
angular.module('healthmonApp')
  .controller('DashboardCtrl', function ($rootScope, apiRoot, $location, $http, $scope) {
    var self = this;
    $scope.chartHeight = window.innerHeight*0.35+'px';
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
