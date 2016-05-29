'use strict';

/**
 * @ngdoc service
 * @name healthmonApp.UserBloodPressure
 * @description
 * # UserBloodPressure
 * Factory in the healthmonApp.
 */
angular.module('healthmonApp')
  .factory('UserBloodPressure', function ($resource, apiRoot) {
    return $resource(apiRoot+'/api/v1/blood-pressures');
  });
