'use strict';

/**
 * @ngdoc function
 * @name healthmonApp.controller:UserBloodPressureCtrl
 * @description
 * # UserBloodPressureCtrl
 * Controller of the healthmonApp
 */
angular.module('healthmonApp')
  .controller('UserBloodPressureCtrl', function (UserBloodPressure, $filter, $scope, ChartLabels, $rootScope) {
    var self = this;
    var series = 'Blood Pressure';
    self.promises = [];
    self.bloodPressures = [];
    self.lastBloodPressure = null;
    self.chartActive = false;

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

    function loadDataToChart() {
      var seriesData = [];
      angular.forEach(ChartLabels.list, function(date, index) {
        var found = false;
        angular.forEach(self.bloodPressures, function(value) {
          var inserted = $filter('date') (new Date(value.insertDate), 'dd.MM');
          if(inserted === date) {
            seriesData.insert(index, value.diastolic);
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

    $scope.$watchCollection('ubpc.bloodPressures',function () {
      if(self.chartActive) {
        loadDataToChart();
      }
    });

    loadBloodPressures();

    self.addBloodPressure = addBloodPressure;
    self.removeChartData = removeDataFromChart;
    self.addChartData = loadDataToChart;
  });
