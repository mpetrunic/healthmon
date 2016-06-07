'use strict';

describe('Service: ActivityType', function () {

  // load the service's module
  beforeEach(module('healthmonApp'));

  // instantiate service
  var ActivityType;
  beforeEach(inject(function (_ActivityType_) {
    ActivityType = _ActivityType_;
  }));

  it('should do something', function () {
    expect(!!ActivityType).toBe(true);
  });

});
