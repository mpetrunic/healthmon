'use strict';

/**
 * @ngdoc service
 * @name healthmonApp.UserWeight
 * @description
 * # UserWeight
 * Factory in the healthmonApp.
 */
angular.module('healthmonApp')
  .factory('UserWeight', function (apiRoot, $resource) {
    return $resource(apiRoot+'/api/v1/weights/:id');
  });
