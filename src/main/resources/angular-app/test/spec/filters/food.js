'use strict';

describe('Filter: food', function () {

  // load the filter's module
  beforeEach(module('healthmonApp'));

  // initialize a new instance of the filter before each test
  var food;
  beforeEach(inject(function ($filter) {
    food = $filter('food');
  }));

  it('should return the input prefixed with "food filter:"', function () {
    var text = 'angularjs';
    expect(food(text)).toBe('food filter: ' + text);
  });

});
