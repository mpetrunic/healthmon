'use strict';

describe('Controller: UserBloodPressureCtrl', function () {

  // load the controller's module
  beforeEach(module('healthmonApp'));

  var UserbloodpressureCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    UserbloodpressureCtrl = $controller('UserbloodpressureCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(UserbloodpressureCtrl.awesomeThings.length).toBe(3);
  });
});
