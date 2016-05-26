package hr.fer.zpr.marinpetrunic.healthmon.models;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author MarinPetrunic
 */
public class HeartRateModel implements Serializable {

    private Integer userHeartRateId;

    private Integer userId;

    private Integer heartRate;

    private LocalDateTime insertDate;

    public Integer getUserHeartRateId() {
        return userHeartRateId;
    }

    public void setUserHeartRateId(Integer userHeartRateId) {
        this.userHeartRateId = userHeartRateId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
    }
}
