package hr.fer.zpr.marinpetrunic.healthmon.controllers.requests;

import hr.fer.zpr.marinpetrunic.healthmon.models.HeartRateModel;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author MarinPetrunic
 */
public class StoreHeartRateRequest implements Serializable {

    @NotNull
    @Min(20)
    @Max(200)
    private Integer heartRate;

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public HeartRateModel toHeartRateModel() {
        HeartRateModel model = new HeartRateModel();
        model.setHeartRate(heartRate);
        return model;
    }
}
