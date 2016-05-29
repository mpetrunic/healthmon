'use strict';

describe('Service: BodyTemperature', function () {

  // load the service's module
  beforeEach(module('healthmonApp'));

  // instantiate service
  var BodyTemperature;
  beforeEach(inject(function (_BodyTemperature_) {
    BodyTemperature = _BodyTemperature_;
  }));

  it('should do something', function () {
    expect(!!BodyTemperature).toBe(true);
  });

});
