'use strict';

/**
 * @ngdoc function
 * @name healthmonApp.controller:SignupCtrl
 * @description
 * # SignupCtrl
 * Controller of the healthmonApp
 */
angular.module('healthmonApp')
  .controller('SignupCtrl', function (User, $location) {
    var self = this;

    self.promises = [];

    String.prototype.capitalizeFirstLetter = function () {
      return this.charAt(0).toUpperCase() + this.slice(1);
    };

    function signUp(user) {
      var query = User.save(angular.copy(user)).$promise;
      self.promises.push(query);
      query.then(function () {
        $location.path('#/');
      }, function (error) {
        console.log(error);
        if (error.status === 400) {
          self.error = error.data.errors[0].field.capitalizeFirstLetter() + ' ' + error.data.errors[0].message + '!';
        } else {
          self.error = 'Something went wrong!';
        }
      });
    }

    self.signUp = signUp;

  });
