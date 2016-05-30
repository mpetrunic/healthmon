'use strict';

describe('Service: Meal', function () {

  // load the service's module
  beforeEach(module('healthmonApp'));

  // instantiate service
  var Meal;
  beforeEach(inject(function (_Meal_) {
    Meal = _Meal_;
  }));

  it('should do something', function () {
    expect(!!Meal).toBe(true);
  });

});
