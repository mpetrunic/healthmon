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
    self.promises = [];
    self.popoverActive = false;

    function loadUserWeights() {
      var query = UserWeight.query().$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.weighs = response;
        self.lastWeight = self.weighs[self.weighs.length-1];
      });
    }

    function addNewWeight(weight) {
      var query = UserWeight.save({weight: weight}).$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.weighs.push(response);
        self.lastWeight = response;
        self.popoverActive = false;
      }, function(error) {
        self.addWeightError = error.data.message;
      });
    }

    loadUserWeights();

    self.addNewWeight = addNewWeight;
  });
