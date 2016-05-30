'use strict';

describe('Controller: UsermealCtrl', function () {

  // load the controller's module
  beforeEach(module('healthmonApp'));

  var UsermealCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    UsermealCtrl = $controller('UsermealCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(UsermealCtrl.awesomeThings.length).toBe(3);
  });
});
