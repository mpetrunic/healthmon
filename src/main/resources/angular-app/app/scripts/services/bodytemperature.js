'use strict';

/**
 * @ngdoc service
 * @name healthmonApp.BodyTemperature
 * @description
 * # BodyTemperature
 * Factory in the healthmonApp.
 */
angular.module('healthmonApp')
  .factory('BodyTemperature', function ($resource, apiRoot) {
    return $resource(apiRoot+'/api/v1/temperatures/:id');
  });
