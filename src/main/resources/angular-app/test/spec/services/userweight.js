'use strict';

describe('Service: UserWeight', function () {

  // load the service's module
  beforeEach(module('healthmonApp'));

  // instantiate service
  var UserWeight;
  beforeEach(inject(function (_UserWeight_) {
    UserWeight = _UserWeight_;
  }));

  it('should do something', function () {
    expect(!!UserWeight).toBe(true);
  });

});
