'use strict';

/**
 * @ngdoc service
 * @name healthmonApp.Weather
 * @description
 * # Weather
 * Factory in the healthmonApp.
 */
angular.module('healthmonApp')
  .factory('Weather', function ($resource, apiRoot) {
    return $resource(apiRoot+'/api/v1/locations/:locationId/weathers/:id');
  });
