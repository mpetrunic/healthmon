'use strict';

/**
 * @ngdoc function
 * @name healthmonApp.controller:UserBloodPressureCtrl
 * @description
 * # UserBloodPressureCtrl
 * Controller of the healthmonApp
 */
angular.module('healthmonApp')
  .controller('UserBloodPressureCtrl', function (UserBloodPressure) {
    var self = this;

    self.promises = [];
    self.bloodPressures = [];
    self.lastBloodPressure = null;

    function loadBloodPressures() {
      var query = UserBloodPressure.query().$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.bloodPressures = response;
        self.lastBloodPressure = self.bloodPressures[self.bloodPressures.length-1];
      });
    }

    function addBloodPressure(bloodPressure) {
      var query = UserBloodPressure.save(bloodPressure).$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.bloodPressures.push(response);
        self.lastBloodPressure = response;
        self.popoverActive = false;
      }, function(error) {
        self.addBloodPressureError = error.data.message;
      });
    }

    loadBloodPressures();

    self.addBloodPressure = addBloodPressure;
  });
