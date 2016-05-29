'use strict';

/**
 * @ngdoc function
 * @name healthmonApp.controller:UserWeightCtrl
 * @description
 * # UserWeightCtrl
 * Controller of the healthmonApp
 */
angular.module('healthmonApp')
  .controller('UserWeightCtrl', function ($rootScope, UserWeight) {
    var self = this;
    self.weighs = [];
    self.lastWeight = 0;
    self.promises = [];

    function loadUserWeights() {
      var query = UserWeight.query().$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.weighs = response;
        self.lastWeight = self.weighs[self.weighs.length-1];
      });
    }

    loadUserWeights();
  });
