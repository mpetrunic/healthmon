'use strict';

/**
 * @ngdoc function
 * @name healthmonApp.controller:UserHeartRateCtrl
 * @description
 * # UserHeartRateCtrl
 * Controller of the healthmonApp
 */
angular.module('healthmonApp')
  .controller('UserHeartRateCtrl', function (UserHeartRate) {
    var self = this;
    self.promises = [];
    self.heartRates = [];
    self.popoverActive = false;

    function loadHeartRates() {
      var query = UserHeartRate.query().$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.heartRates = response;
        self.lastHeartRate = self.heartRates[self.heartRates.length-1];
      });
    }

    function addHeartRate(heartRate) {
      var query = UserHeartRate.save({heartRate: heartRate}).$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.heartRates.push(response);
        self.lastHeartRate = response;
        self.popoverActive = false;
      }, function(error) {
        self.addHeartRateError = error.data.message;
      });
    }

    loadHeartRates();

    self.addHeartRate = addHeartRate;
  });
