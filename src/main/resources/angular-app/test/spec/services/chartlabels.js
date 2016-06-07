'use strict';

describe('Service: ChartLabels', function () {

  // load the service's module
  beforeEach(module('healthmonApp'));

  // instantiate service
  var ChartLabels;
  beforeEach(inject(function (_ChartLabels_) {
    ChartLabels = _ChartLabels_;
  }));

  it('should do something', function () {
    expect(!!ChartLabels).toBe(true);
  });

});
