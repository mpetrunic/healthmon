'use strict';

describe('Service: UserMeal', function () {

  // load the service's module
  beforeEach(module('healthmonApp'));

  // instantiate service
  var UserMeal;
  beforeEach(inject(function (_UserMeal_) {
    UserMeal = _UserMeal_;
  }));

  it('should do something', function () {
    expect(!!UserMeal).toBe(true);
  });

});
