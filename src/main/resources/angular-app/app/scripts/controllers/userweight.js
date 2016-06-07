'use strict';

/**
 * @ngdoc function
 * @name healthmonApp.controller:UserWeightCtrl
 * @description
 * # UserWeightCtrl
 * Controller of the healthmonApp
 */
angular.module('healthmonApp')
  .controller('UserWeightCtrl', function ($rootScope, UserWeight, $filter, $scope, ChartLabels) {
    var self = this;
    var series = 'Weight';
    self.weighs = [];
    self.promises = [];
    self.popoverActive = false;
    self.chartActive = false;

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

    function loadDataToChart() {
      var seriesData = [];
      angular.forEach(ChartLabels.list, function(date, index) {
        var found = false;
        angular.forEach(self.weighs, function(value) {
          var inserted = $filter('date') (new Date(value.insertDate), 'dd.MM');
          if(inserted === date) {
            seriesData.insert(index, value.weight);
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

    $scope.$watchCollection('uwc.weighs',function () {
      if(self.chartActive) {
        loadDataToChart();
      }
    });

    loadUserWeights();

    self.addNewWeight = addNewWeight;
    self.removeChartData = removeDataFromChart;
    self.addChartData = loadDataToChart;
  });
