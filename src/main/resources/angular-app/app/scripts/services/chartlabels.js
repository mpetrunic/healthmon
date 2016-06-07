'use strict';

/**
 * @ngdoc service
 * @name healthmonApp.ChartLabels
 * @description
 * # ChartLabels
 * Service in the healthmonApp.
 */
angular.module('healthmonApp')
  .service('ChartLabels', function () {
    var labels = {};

    labels.list = [];

    labels.push = function(label) {
      labels.list.push(label);
    };

    labels.addAll = function(data) {
      angular.forEach(data, function(value) {
        labels.push(value);
      });
    };

    return labels;
  });
