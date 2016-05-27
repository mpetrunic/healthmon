package hr.fer.zpr.marinpetrunic.healthmon.models;

import java.io.Serializable;

/**
 * @author MarinPetrunic
 */
public class MealModel implements Serializable {

    private Integer id;

    private String name;

    private Integer calories;

    private Float fat;

    private Float proteins;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", fat=" + fat +
                ", proteins=" + proteins +
                '}';
    }
}
