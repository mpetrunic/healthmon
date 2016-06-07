'use strict';

/**
 * @ngdoc function
 * @name healthmonApp.controller:UserStatsChartCtrl
 * @description
 * # UserStatsChartCtrl
 * Controller of the healthmonApp
 */
angular.module('healthmonApp')
  .controller('UserStatsChartCtrl', function ($filter, $rootScope, ChartLabels, $scope) {
    var self = this;
    $scope.chartHeight = window.innerHeight*0.30;
    self.dataSets = {
      'Weight': {
        color: '#d1b993'
      },
      'Heart Rate': {
        color: '#57889c'
      },
      'Body Temperature': {
        color: '#f4b162'
      },
      'Blood Pressure': {
        color: '#d95043'
      },
      'Weather': {
        color: '#ffcc66'
      },
      'Activity': {
        color: '#26c281'
      }
    };
    self.options = {
      responsive: true,
      maintainAspectRatio: false
    };
    self.labels = [];
    self.series = [];
    self.data = [];
    self.colours = [];

    Array.prototype.insert = function (index, item) {
      this.splice(index, 0, item);
    };

    Array.prototype.remove = function (index) {
      this.splice(index, 1);
    };

    function daysInMonth(month,year) {
      return new Date(year, month, 0).getDate();
    }

    function loadLabels() {
      var currentDate = new Date();
      var numberOfDays = daysInMonth(currentDate.getYear(), currentDate.getMonth());
      for (var i = 1; i < numberOfDays; i++) {
        var date = new Date(currentDate.getYear(), currentDate.getMonth(), i);
        self.labels.push($filter('date')(date, 'dd.MM'));
      }
      ChartLabels.addAll(self.labels);
    }

    function loadSeriesData(series, data) {
      var seriesSettings = self.dataSets[series];
      if(self.series.indexOf(series) === -1) {
        self.colours.push(seriesSettings.color);
        self.series.push(series);
        self.data.push(data);
      } else {
        console.log('updating');
        self.data.remove(self.series.indexOf(series));
        self.data.insert(self.series.indexOf(series), data);
      }
    }

    function removeSeriesData(series){
      var index = self.series.indexOf(series);
      if(index === -1) {
        return;
      }
      self.colours.remove(index);
      self.data.remove(index);
      self.series.remove(index);
    }

    loadLabels();

    $scope.$on('AddChartData', function(e, series, data) {
      loadSeriesData(series, data);
    });

    $scope.$on('RemoveChartData', function(e, series) {
      removeSeriesData(series);
    });
  });
