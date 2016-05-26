package hr.fer.zpr.marinpetrunic.healthmon.controllers.requests;

import hr.fer.zpr.marinpetrunic.healthmon.models.BloodPressureModel;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author MarinPetrunic
 */
public class StoreBloodPressureRequest implements Serializable {

    @NotNull
    @Min(40)
    @Max(100)
    private Integer diastolic;

    @NotNull
    @Min(70)
    @Max(190)
    private Integer systolic;

    public Integer getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(Integer diastolic) {
        this.diastolic = diastolic;
    }

    public Integer getSystolic() {
        return systolic;
    }

    public void setSystolic(Integer systolic) {
        this.systolic = systolic;
    }

    public BloodPressureModel toBloodPressureModel() {
        BloodPressureModel model = new BloodPressureModel();
        model.setDiastolic(diastolic);
        model.setSystolic(systolic);
        return model;
    }
}
