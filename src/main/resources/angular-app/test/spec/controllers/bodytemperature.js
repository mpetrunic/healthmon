'use strict';

describe('Controller: BodyTemperatureCtrl', function () {

  // load the controller's module
  beforeEach(module('healthmonApp'));

  var BodytemperatureCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    BodytemperatureCtrl = $controller('BodytemperatureCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(BodytemperatureCtrl.awesomeThings.length).toBe(3);
  });
});
