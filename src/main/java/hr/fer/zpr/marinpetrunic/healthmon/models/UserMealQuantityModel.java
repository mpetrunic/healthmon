package hr.fer.zpr.marinpetrunic.healthmon.models;

import java.io.Serializable;

/**
 * @author MarinPetrunic
 */
public class UserMealQuantityModel implements Serializable {

    private MealModel meal;

    private Integer quantity;

    public MealModel getMeal() {
        return meal;
    }

    public void setMeal(MealModel meal) {
        this.meal = meal;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
