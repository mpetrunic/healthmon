'use strict';

/**
 * @ngdoc function
 * @name healthmonApp.controller:BodyTemperatureCtrl
 * @description
 * # BodyTemperatureCtrl
 * Controller of the healthmonApp
 */
angular.module('healthmonApp')
  .controller('BodyTemperatureCtrl', function (BodyTemperature, $filter, $scope, ChartLabels, $rootScope) {
    var self = this;
    var series = 'Body Temperature';
    self.promises = [];
    self.bodyTemperatures = [];
    self.popoverActive = false;
    self.chartActive = false;

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

    function loadDataToChart() {
      var seriesData = [];
      angular.forEach(ChartLabels.list, function(date, index) {
        var found = false;
        angular.forEach(self.bodyTemperatures, function(value) {
          var inserted = $filter('date') (new Date(value.insertDate), 'dd.MM');
          if(inserted === date) {
            seriesData.insert(index, value.temperature);
            found = true;
          }
        });
        if(!found) {
          seriesData.insert(index, undefined);
        }
      });
      self.chartActive = true;
      $rootScope.$broadcast('AddChartData', series, seriesData);
    }

    function removeDataFromChart() {
      self.chartActive = false;
      $rootScope.$broadcast('RemoveChartData', series);
    }

    $scope.$watchCollection('btc.bodyTemperatures',function () {
      if(self.chartActive) {
        loadDataToChart();
      }
    });

    loadBodyTemperatures();

    self.addTemperature = addTemperature;
    self.removeChartData = removeDataFromChart;
    self.addChartData = loadDataToChart;
  });
