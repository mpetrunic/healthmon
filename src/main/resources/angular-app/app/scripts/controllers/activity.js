'use strict';

/**
 * @ngdoc function
 * @name healthmonApp.controller:ActivityCtrl
 * @description
 * # ActivityCtrl
 * Controller of the healthmonApp
 */
angular.module('healthmonApp')
  .controller('ActivityCtrl', function (Activity, UserMeal, ActivityType, $filter, $scope, ChartLabels, $rootScope) {
    var self = this;
    var baseCalories = -2000;
    var series = 'Activity';

    self.promises = [];
    self.activities = [];
    self.userMeals = [];
    self.activityTypes = [];
    self.popoverActive = false;
    self.chartActive = false;

    function getActivitiesCalories(date) {
      var cal = 0;
      angular.forEach(self.activities, function(activity) {
        var activityDate = new Date(activity.insertDate);
        if(activityDate.toDateString() === date.toDateString()) {
          cal +=activity.caloriesBurned;
        }
      });
      return cal;
    }

    function getMealCalories(date) {
      var cal = 0;
      if(self.userMeals.length === 0) {
        return 0;
      }
      var mealsByType = $filter('filter')(self.userMeals, {date: $filter('date')(date, 'yyyy-MM-dd')})[0];
      if(!mealsByType) {
        return 0;
      }
      angular.forEach(mealsByType.meals, function(meals) {
        angular.forEach(meals, function(meal) {
          cal +=(meal.meal.calories * meal.quantity)/100;
        });
      });
      return cal;
    }

    function calculateTotalCalories() {
      return baseCalories - getActivitiesCalories(new Date()) + getMealCalories(new Date());
    }

    function calculateTotalCaloriesByDate(date) {
      return baseCalories - getActivitiesCalories(date) + getMealCalories(date);
    }

    function loadActivities() {
      var query = Activity.query().$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.activities = response;
      });
    }

    function loadMeals() {
      var query = UserMeal.query().$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.userMeals = response;
      });
    }

    function loadActivityTypes() {
      var query = ActivityType.query().$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.activityTypes = response;
      });
    }

    function addUserActivity(userActivity) {
      var query = Activity.save(userActivity).$promise;
      self.promises.push(query);
      query.then(function() {
        loadActivities();
        self.popoverActive = false;
      }, function(error) {
        self.addUserActivityError = error.data.message;
      });
    }

    function loadDataToChart() {
      var seriesData = [];
      angular.forEach(ChartLabels.list, function(date, index) {
        var rDate = new Date();
        console.log(date);
        rDate.setDate(date.split('.')[0]);
        rDate.setMonth(date.split('.')[1]-1);
        console.log(date.split('.')[1]);
        console.log($filter('date')(rDate, 'dd.MM.yyyy.'));
        seriesData.insert(index, calculateTotalCaloriesByDate(rDate));
      });
      self.chartActive = true;
      $rootScope.$broadcast('AddChartData', series, seriesData);
    }

    function removeDataFromChart() {
      self.chartActive = false;
      $rootScope.$broadcast('RemoveChartData', series);
    }

    $scope.$watchCollection('ac.userMeals',function () {
      if(self.chartActive) {
        loadDataToChart();
      }
    });

    $scope.$watchCollection('ac.activities',function () {
      if(self.chartActive) {
        loadDataToChart();
      }
    });

    loadActivities();
    loadMeals();
    loadActivityTypes();

    $scope.$on('UserMealAddedEvent', function() {
      loadMeals();
    });

    self.calculateCalories = calculateTotalCalories;
    self.addUserActivity = addUserActivity;
    self.removeChartData = removeDataFromChart;
    self.addChartData = loadDataToChart;
  });
