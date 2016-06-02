package hr.fer.zpr.marinpetrunic.healthmon.controllers.requests;

import hr.fer.zpr.marinpetrunic.healthmon.controllers.validation.Exists;
import hr.fer.zpr.marinpetrunic.healthmon.models.UserActivityModel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author MarinPetrunic
 */
public class StoreUserActivityRequest implements Serializable {

    @NotNull
    @Exists(column = "activity_id", table = "activity")
    private Integer activityId;

    @NotNull
    @Min(1)
    private Double activityLength;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Double getActivityLength() {
        return activityLength;
    }

    public void setActivityLength(Double activityLength) {
        this.activityLength = activityLength;
    }

    public UserActivityModel toUserActivityModel() {
        UserActivityModel model = new UserActivityModel();
        model.setActivityId(activityId);
        model.setActivityLenght(activityLength);
        return model;
    }
}
