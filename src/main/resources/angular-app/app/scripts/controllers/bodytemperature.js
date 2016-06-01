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
    self.popoverActive = false;

    function loadBodyTemperatures() {
      var query = BodyTemperature.query().$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.bodyTemperatures = response;
        self.lastBodyTemperature = self.bodyTemperatures[self.bodyTemperatures.length-1];
      });
    }

    function addTemperature(temperature) {
      var query = BodyTemperature.save({temperature: temperature}).$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.bodyTemperatures.push(response);
        self.lastBodyTemperature = response;
        self.popoverActive = false;
      }, function(error) {
        self.addTemperatureError = error.data.message;
      });
    }

    loadBodyTemperatures();

    self.addTemperature = addTemperature;
  });
