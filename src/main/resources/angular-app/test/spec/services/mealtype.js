'use strict';

describe('Service: MealType', function () {

  // load the service's module
  beforeEach(module('healthmonApp'));

  // instantiate service
  var MealType;
  beforeEach(inject(function (_MealType_) {
    MealType = _MealType_;
  }));

  it('should do something', function () {
    expect(!!MealType).toBe(true);
  });

});
