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
    $scope.foods = [{id: 1, name: 'Test'}];

    function loadMealTypes() {
      var query = MealType.query().$promise;
      self.promises.push(query);
      query.then(function(response) {
        self.mealTypes = response;
      });
    }

    function formatMealModel(meal, mealType, quantity) {
      return {
        name: meal.name,
        quantity: quantity,
        calories: (meal.calories * quantity)/100,
        fat: (meal.fat * quantity)/100,
        proteins: (meal.proteins * quantity)/100,
        type: mealType
      };
    }

    function extractTodayMeals(userMealsByDays) {
      var mealsByType = $filter('filter')(userMealsByDays, {date: $filter('date')(new Date(), 'yyyy-MM-dd')})[0];
      angular.forEach(mealsByType.meals, function(meals, mealType) {
        angular.forEach(meals, function(meal) {
          $scope.todayMeals.push(formatMealModel(meal.meal, mealType, meal.quantity));
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

    function searchFood(search) {
      Meal.query({query: search}, function(response) {
        $scope.foods = response;
      });
    }

    function getMealTypeName(mealTypeId) {
      return $filter('filter')(self.mealTypes, {id: mealTypeId})[0].name;
    }

    function storeUserMeal(meal) {
      console.log(meal);
      var query = UserMeal.save(meal).$promise;
      self.promises.push(query);
      query.then(function(response) {
        console.log(response);
        Meal.get({id: response.mealId}, function(meal) {
          $scope.todayMeals.push(formatMealModel(meal, getMealTypeName(response.mealTypeId), response.quantity));
          $scope.todayMeals = $filter('orderBy')($scope.todayMeals, '+type');
          $scope.meal = {};
        });
      }, function(error) {
        console.log(error);
        if(error.status === 400) {
          $scope.addUserMealError = error.data.message+'Field '+error.data.errors[0].defaultMessage;
        } else {
          $scope.addUserMealError = error.data.message;
        }
      });
    }

    loadMealTypes();
    loadUserMealsPerDays();
    searchFood('');

    self.getTotalTodayCalories = getTotalTodayCalories;
    self.getTotalTodayFats = getTotalTodayFats;
    self.getTotalTodayProteins = getTotalTodayProteins;
    self.searchFood = searchFood;
    self.storeUserMeal = storeUserMeal;
  });
