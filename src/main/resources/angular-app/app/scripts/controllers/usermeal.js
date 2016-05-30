'use strict';

/**
 * @ngdoc function
 * @name healthmonApp.controller:UserMealCtrl
 * @description
 * # UserMealCtrl
 * Controller of the healthmonApp
 */
angular.module('healthmonApp')
  .controller('UserMealCtrl', function (UserMeal, Meal, MealType, $filter, $scope) {
    var self = this;
    self.promises = [];
    self.mealTypes = [];
    self.userMealsByDays = [];
    $scope.todayMeals = [];

    function loadMealTypes() {
      var query = MealType.query().$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.mealTypes = response;
      });
    }

    function extractTodayMeals(userMealsByDays) {
      var mealsByType = $filter('filter')(userMealsByDays, {date: $filter('date')(new Date(), 'yyyy-MM-dd')})[0];
      angular.forEach(mealsByType.meals, function(meals, mealType) {
        angular.forEach(meals, function(meal) {
          $scope.todayMeals.push({
            name: meal.meal.name,
            quantity: meal.quantity,
            calories: (meal.meal.calories * meal.quantity)/100,
            fat: (meal.meal.fat * meal.quantity)/100,
            proteins: (meal.meal.proteins * meal.quantity)/100,
            type: mealType
          });
        });
      });
      $scope.todayMeals = $filter('orderBy')($scope.todayMeals, '+type');
    }

    function loadUserMealsPerDays() {
      var query = UserMeal.query().$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.userMealsByDays = response;
        self.todayMeals = extractTodayMeals(self.userMealsByDays);
      });
    }

    function getTotalTodayCalories() {
      var total = 0;
      angular.forEach($scope.todayMeals, function(meal) {
        total += meal.calories;
      });
      return total;
    }

    function getTotalTodayProteins() {
      var total = 0;
      angular.forEach($scope.todayMeals, function(meal) {
        total += meal.proteins;
      });
      return total;
    }

    function getTotalTodayFats() {
      var total = 0;
      angular.forEach($scope.todayMeals, function(meal) {
        total += meal.fat;
      });
      return total;
    }

    loadMealTypes();
    loadUserMealsPerDays();

    self.getTotalTodayCalories = getTotalTodayCalories;
    self.getTotalTodayFats = getTotalTodayFats;
    self.getTotalTodayProteins = getTotalTodayProteins;

  });
