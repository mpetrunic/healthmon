'use strict';

describe('Service: UserHeartRate', function () {

  // load the service's module
  beforeEach(module('healthmonApp'));

  // instantiate service
  var UserHeartRate;
  beforeEach(inject(function (_UserHeartRate_) {
    UserHeartRate = _UserHeartRate_;
  }));

  it('should do something', function () {
    expect(!!UserHeartRate).toBe(true);
  });

});
