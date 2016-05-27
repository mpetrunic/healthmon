package hr.fer.zpr.marinpetrunic.healthmon.models;

import java.time.LocalDateTime;

/**
 * @author MarinPetrunic
 */
public class UserMealModel {

    private Integer userMealId;

    private Integer userId;

    private Integer mealTypeId;

    private Integer mealId;

    private Integer quantity;

    private LocalDateTime insertDate;

    public Integer getUserMealId() {
        return userMealId;
    }

    public void setUserMealId(Integer userMealId) {
        this.userMealId = userMealId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
    }
}
