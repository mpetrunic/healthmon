package hr.fer.zpr.marinpetrunic.healthmon.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author MarinPetrunic
 */
public class ActivityModel implements Serializable {

    public ActivityModel() {
    }

    public ActivityModel(String name, Float averageCaloriesPerMin) {
        this.name = name;
        this.averageCaloriesPerMin = averageCaloriesPerMin;
    }

    public ActivityModel(Integer id, String name, Float averageCaloriesPerMin) {
        this.activityId = id;
        this.name = name;
        this.averageCaloriesPerMin = averageCaloriesPerMin;
    }

    @JsonProperty(value = "id")
    private Integer activityId;

    private String name;

    private Float averageCaloriesPerMin;

    public Integer getId() {
        return activityId;
    }

    public void setId(Integer id) {
        this.activityId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAverageCaloriesPerMin() {
        return averageCaloriesPerMin;
    }

    public void setAverageCaloriesPerMin(Float averageCaloriesPerMin) {
        this.averageCaloriesPerMin = averageCaloriesPerMin;
    }
}
