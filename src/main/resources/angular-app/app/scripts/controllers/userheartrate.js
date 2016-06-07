'use strict';

/**
 * @ngdoc function
 * @name healthmonApp.controller:UserHeartRateCtrl
 * @description
 * # UserHeartRateCtrl
 * Controller of the healthmonApp
 */
angular.module('healthmonApp')
  .controller('UserHeartRateCtrl', function (UserHeartRate, $filter, $scope, ChartLabels, $rootScope) {
    var self = this;
    var series = 'Heart Rate';
    self.promises = [];
    self.heartRates = [];
    self.popoverActive = false;
    self.chartActive = false;


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

    function loadDataToChart() {
      var seriesData = [];
      angular.forEach(ChartLabels.list, function(date, index) {
        var found = false;
        angular.forEach(self.heartRates, function(value) {
          var inserted = $filter('date') (new Date(value.insertDate), 'dd.MM');
          if(inserted === date) {
            seriesData.insert(index, value.heartRate);
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

    $scope.$watchCollection('uhrc.heartRates',function () {
      if(self.chartActive) {
        loadDataToChart();
      }
    });

    loadHeartRates();

    self.addHeartRate = addHeartRate;
    self.removeChartData = removeDataFromChart;
    self.addChartData = loadDataToChart;
  });
