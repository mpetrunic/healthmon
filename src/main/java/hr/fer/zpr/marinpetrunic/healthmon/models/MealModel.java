package hr.fer.zpr.marinpetrunic.healthmon.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author MarinPetrunic
 */
public class MealModel implements Serializable {

    @JsonProperty(value = "id")
    private Integer mealId;

    private String name;

    private Integer calories;

    private Float fat;

    private Float proteins;

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Float getFat() {
        return fat;
    }

    public void setFat(Float fat) {
        this.fat = fat;
    }

    public Float getProteins() {
        return proteins;
    }

    public void setProteins(Float proteins) {
        this.proteins = proteins;
    }

    @Override
    public String toString() {
        return "MealModel{" +
                "id=" + mealId +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", fat=" + fat +
                ", proteins=" + proteins +
                '}';
    }
}
