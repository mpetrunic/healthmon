'use strict';

describe('Service: UserBloodPressure', function () {

  // load the service's module
  beforeEach(module('healthmonApp'));

  // instantiate service
  var UserBloodPressure;
  beforeEach(inject(function (_UserBloodPressure_) {
    UserBloodPressure = _UserBloodPressure_;
  }));

  it('should do something', function () {
    expect(!!UserBloodPressure).toBe(true);
  });

});
