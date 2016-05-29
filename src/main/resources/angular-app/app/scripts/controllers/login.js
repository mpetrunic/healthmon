'use strict';

/**
 * @ngdoc function
 * @name healthmonApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the healthmonApp
 */
angular.module('healthmonApp')
  .controller('LoginCtrl', function (User, $location, $rootScope, $http, apiRoot, base64) {

    var self = this;

    self.promises = [];
    self.error = undefined;

    function authenticate(credentials) {
      /** @namespace $rootScope.authenticatedUser */
      if ($rootScope.authenticatedUser) {
        $location.path('#/dashboard');
      } else {
        var headers = credentials ? {
          Authorization: 'Basic ' + base64.encode(credentials.username + ':' + credentials.password)
        } : {};
        var promise = $http.get(apiRoot + '/api/v1/users/me', {headers: headers});
        self.promises.push(promise);
        promise.then(function (response) {
          $rootScope.authenticatedUser = response.principal;
          $location.path('/dashboard');
        }, function (error) {
          console.log(error);
          if (error.status === 401) {
            self.error = 'Wrong authentication data!';
          } else if (error.status === -1) {
            self.error = 'Undefined error!';
          } else {
            self.error = error.data.message;
          }
        });
      }
    }

    self.authenticate = authenticate;

  });
