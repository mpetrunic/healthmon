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
    self.lastHeartRate = 0;

    function loadHeartRates() {
      var query = UserHeartRate.query().$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.heartRates = response;
        self.lastHeartRate = self.heartRates[self.heartRates.length-1];
      });
    }

    loadHeartRates();
  });
