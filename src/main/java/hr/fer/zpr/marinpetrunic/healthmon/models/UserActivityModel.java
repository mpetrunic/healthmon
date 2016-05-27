package hr.fer.zpr.marinpetrunic.healthmon.models;

import java.time.LocalDateTime;

/**
 * @author MarinPetrunic
 */
public class UserActivityModel {

    private Integer userActivityId;

    private Integer userId;

    private Integer activityId;

    private ActivityModel activityModel;

    private Integer caloriesBurned;

    private Double activityLenght;

    private LocalDateTime insertDate;

    public Integer getUserActivityId() {
        return userActivityId;
    }

    public void setUserActivityId(Integer userActivityId) {
        this.userActivityId = userActivityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public ActivityModel getActivityModel() {
        return activityModel;
    }

    public void setActivityModel(ActivityModel activityModel) {
        this.activityModel = activityModel;
    }

    public Integer getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(Integer caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public Double getActivityLenght() {
        return activityLenght;
    }

    public void setActivityLenght(Double activityLenght) {
        this.activityLenght = activityLenght;
    }

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
    }
}
