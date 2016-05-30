'use strict';

/**
 * @ngdoc service
 * @name healthmonApp.MealType
 * @description
 * # MealType
 * Factory in the healthmonApp.
 */
angular.module('healthmonApp')
  .factory('MealType', function ($resource, apiRoot) {
    return $resource(apiRoot+'/api/v1/meal-types');
  });
