package hr.fer.zpr.marinpetrunic.healthmon.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MarinPetrunic
 */
public class UserMealsByDayModel implements Serializable {

    private LocalDate date;

    private Map<MealTypeModel, List<UserMealQuantityModel>> meals = new LinkedHashMap<>();

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Map<MealTypeModel, List<UserMealQuantityModel>> getMeals() {
        return meals;
    }

    public void setMeals(Map<MealTypeModel, List<UserMealQuantityModel>> meals) {
        this.meals = meals;
    }
}
