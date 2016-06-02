package hr.fer.zpr.marinpetrunic.healthmon.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author MarinPetrunic
 */
public class MealTypeModel implements Serializable {

    public MealTypeModel() {
    }

    public MealTypeModel(Integer mealTypeId, String name) {
        this.mealTypeId = mealTypeId;
        this.name = name;
    }

    public MealTypeModel(String name) {
        this.name = name;
    }

    @JsonProperty(value = "id")
    private Integer mealTypeId;

    private String name;

    public Integer getMealTypeId() {
        return mealTypeId;
    }

    public void setMealTypeId(Integer mealTypeId) {
        this.mealTypeId = mealTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
