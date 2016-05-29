'use strict';

describe('Controller: UserheartrateCtrl', function () {

  // load the controller's module
  beforeEach(module('healthmonApp'));

  var UserheartrateCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    UserheartrateCtrl = $controller('UserheartrateCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(UserheartrateCtrl.awesomeThings.length).toBe(3);
  });
});
