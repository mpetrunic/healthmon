'use strict';

/**
 * @ngdoc function
 * @name healthmonApp.controller:BodyTemperatureCtrl
 * @description
 * # BodyTemperatureCtrl
 * Controller of the healthmonApp
 */
angular.module('healthmonApp')
  .controller('BodyTemperatureCtrl', function (BodyTemperature) {
    var self = this;
    self.promises = [];
    self.bodyTemperatures = [];

    function loadBodyTemperatures() {
      var query = BodyTemperature.query().$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.bodyTemperatures = response;
        self.lastBodyTemperature = self.bodyTemperatures[self.bodyTemperatures.length-1];
      });
    }

    loadBodyTemperatures();
  });
