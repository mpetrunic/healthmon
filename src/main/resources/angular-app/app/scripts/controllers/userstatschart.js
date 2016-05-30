'use strict';

/**
 * @ngdoc function
 * @name healthmonApp.controller:UserStatsChartCtrl
 * @description
 * # UserStatsChartCtrl
 * Controller of the healthmonApp
 */
angular.module('healthmonApp')
  .controller('UserStatsChartCtrl', function () {
    var self = this;
    self.chartHeight = window.innerHeight*0.35;
    self.options = {
      responsive: true,
      maintainAspectRatio: false
    };
    self.labels = ['January', 'February', 'March', 'April', 'May', 'June', 'July'];
    self.series = ['Weight', 'Heart Rate', 'Blood Pressure', 'Body Temperature'];
    self.data = [
      [90, 93, 89, 90, 92, 91, 93],
      [90, 120, 99, 70, 144, 70, 88],
      [120, 140, 100, 120, 120, 120, 125],
      [36.8, 36.9, 36.6, 37.4, 39.4, 39.2, 36.8]
    ];
    self.colours = ['#d1b993', '#57889c', '#d95043', '#f4b162'];
  });
