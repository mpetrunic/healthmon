'use strict';

/**
 * @ngdoc service
 * @name healthmonApp.UserHeartRate
 * @description
 * # UserHeartRate
 * Factory in the healthmonApp.
 */
angular.module('healthmonApp')
  .factory('UserHeartRate', function ($resource, apiRoot) {
    return $resource(apiRoot+'/api/v1/heart-rates/:id');
  });
