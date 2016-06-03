'use strict';

/**
 * @ngdoc service
 * @name healthmonApp.Activity
 * @description
 * # Activity
 * Factory in the healthmonApp.
 */
angular.module('healthmonApp')
  .factory('Activity', function (apiRoot, $resource) {
    return $resource(apiRoot+'/api/v1/user-activities/:id');
  });
