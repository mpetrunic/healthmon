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
    self.lastBloodPressure = undefined;
    self.bloodPressures = [];

    function loadBloodPressures() {
      var query = UserBloodPressure.query().$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.bloodPressures = response;
        self.lastBloodPressure = self.bloodPressures[self.bloodPressures.length-1];
      });
    }

    loadBloodPressures();
  });
