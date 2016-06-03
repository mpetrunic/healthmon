'use strict';

/**
 * @ngdoc service
 * @name healthmonApp.ActivityType
 * @description
 * # ActivityType
 * Factory in the healthmonApp.
 */
angular.module('healthmonApp')
  .factory('ActivityType', function (apiRoot, $resource) {
    return $resource(apiRoot+'/api/v1/activities/:id');
  });
