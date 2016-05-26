package hr.fer.zpr.marinpetrunic.healthmon.models;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author MarinPetrunic
 */
public class BloodPressureModel implements Serializable {

    private Integer userBloodPressureId;

    private Integer userId;

    private Integer diastolic;

    private Integer systolic;

    private LocalDateTime insertDate;

    public Integer getUserBloodPressureId() {
        return userBloodPressureId;
    }

    public void setUserBloodPressureId(Integer userBloodPressureId) {
        this.userBloodPressureId = userBloodPressureId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
    }
}
