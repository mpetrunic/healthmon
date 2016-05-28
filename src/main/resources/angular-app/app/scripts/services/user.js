'use strict';

/**
 * @ngdoc service
 * @name healthmonApp.user
 * @description
 * # user
 * Factory in the healthmonApp.
 */
angular.module('healthmonApp')
  .factory('User', function ($resource, apiRoot) {
      return $resource(apiRoot+'/api/v1/users/:id');
  });
