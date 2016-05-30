'use strict';

/**
 * @ngdoc service
 * @name healthmonApp.UserMeal
 * @description
 * # UserMeal
 * Factory in the healthmonApp.
 */
angular.module('healthmonApp')
  .factory('UserMeal', function ($resource, apiRoot) {
    return $resource(apiRoot+'/api/v1/user-meals/:id');
  });
