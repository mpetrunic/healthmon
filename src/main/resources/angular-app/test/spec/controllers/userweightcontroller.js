'use strict';

describe('Controller: UserweightcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('healthmonApp'));

  var UserweightcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    UserweightcontrollerCtrl = $controller('UserweightcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(UserweightcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
