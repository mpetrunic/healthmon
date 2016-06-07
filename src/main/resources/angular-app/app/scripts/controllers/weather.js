'use strict';

/**
 * @ngdoc function
 * @name healthmonApp.controller:WeatherCtrl
 * @description
 * # WeatherCtrl
 * Controller of the healthmonApp
 */
angular.module('healthmonApp')
  .controller('WeatherCtrl', function (Weather, $filter, $scope, ChartLabels, $rootScope) {
    var self = this;
    var series = 'Weather';
    self.promises = [];
    self.weatherRating = 0;
    self.weatherStatistics = [];
    self.popoverActive = false;self.chartActive = true;

    function calculateTemperatureRating(temperature) {
      if(temperature < 0 || temperature > 45) {
        return 0;
      }
      if(temperature < 10 || temperature > 35) {
        return 1;
      }
      if(temperature < 20 || temperature > 30) {
        return 2;
      }
      return 3;
    }

    function calculateHumidityRating(humidity) {
      if(humidity < 10 || humidity > 90) {
        return 0;
      }
      if(humidity < 20 || humidity > 80) {
        return 1;
      }
      if(humidity < 40 || humidity > 60) {
        return 2;
      }
      return 3;
    }

    function calculateAirPressureRating(airPressure) {
      if(airPressure < 950) {
        return 0;
      }
      if(airPressure < 980) {
        return 1;
      }
      if(airPressure < 1000) {
        return 2;
      }
      if(airPressure < 1013) {
        return 3;
      }
      return 4;
    }

    function calculateWeatherRating(weatherStatistic) {
      if(weatherStatistic === undefined) {
        return 0;
      }
      var score = 0;
      score += calculateTemperatureRating(weatherStatistic.temperature);
      score += calculateHumidityRating(weatherStatistic.humidity);
      score += calculateAirPressureRating(weatherStatistic.airPressure);
      return score;
    }

    function loadWeatherStatistic(locationId) {
      var query = Weather.query({'locationId': locationId}).$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.weatherStatistics = response;
        self.weatherRating = calculateWeatherRating(self.weatherStatistics[self.weatherStatistics.length-1]);
      });
    }

    function loadDataToChart() {
      var seriesData = [];
      angular.forEach(ChartLabels.list, function(date, index) {
        var found = false;
        angular.forEach(self.weatherStatistics, function(value) {
          var inserted = $filter('date') (new Date(value.insertDate), 'dd.MM');
          if(inserted === date) {
            seriesData.insert(index, calculateWeatherRating(value));
            found = true;
          }
        });
        if(!found) {
          seriesData.insert(index, undefined);
        }
      });
      self.chartActive = true;
      $rootScope.$broadcast('AddChartData', series, seriesData);
    }

    function removeDataFromChart() {
      self.chartActive = false;
      $rootScope.$broadcast('RemoveChartData', series);
    }

    $scope.$watchCollection('wc.weatherStatistics',function () {
      if(self.chartActive) {
        loadDataToChart();
      }
    });


    //loading weather data
    if($rootScope.authenticatedUser !== undefined) {
      loadWeatherStatistic($rootScope.authenticatedUser.locationId);
    } else {
      $rootScope.$watch('authenticatedUser', function() {
        if($rootScope.authenticatedUser === undefined) {
          return;
        }
        loadWeatherStatistic($rootScope.authenticatedUser.locationId);
      });
    }

    self.removeChartData = removeDataFromChart;
    self.addChartData = loadDataToChart;
  });
