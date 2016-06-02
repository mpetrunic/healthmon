package hr.fer.zpr.marinpetrunic.healthmon.controllers.requests;

import hr.fer.zpr.marinpetrunic.healthmon.controllers.validation.Exists;
import hr.fer.zpr.marinpetrunic.healthmon.models.UserMealModel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author MarinPetrunic
 */
public class StoreUserMealsRequest implements Serializable{

    @NotNull
    @Exists(column = "meal_type_id", table = "meal_type")
    private Integer mealTypeId;

    @NotNull
    @Exists(column = "meal_id", table = "meal")
    private Integer mealId;

    @NotNull
    @Min(1)
    private Integer quantity;

    public Integer getMealTypeId() {
        return mealTypeId;
    }

    public void setMealTypeId(Integer mealTypeId) {
        this.mealTypeId = mealTypeId;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public UserMealModel toUserMealModel() {
        UserMealModel model = new UserMealModel();
        model.setMealId(mealId);
        model.setMealTypeId(mealTypeId);
        model.setQuantity(quantity);
        return model;
    }
}
