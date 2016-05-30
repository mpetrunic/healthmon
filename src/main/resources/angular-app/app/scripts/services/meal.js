'use strict';

/**
 * @ngdoc service
 * @name healthmonApp.Meal
 * @description
 * # Meal
 * Factory in the healthmonApp.
 */
angular.module('healthmonApp')
  .factory('Meal', function ($resource, apiRoot) {
    return $resource(apiRoot+'/api/v1/meals');
  });
