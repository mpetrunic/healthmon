package hr.fer.zpr.marinpetrunic.healthmon.models;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author MarinPetrunic
 */
public class TemperatureModel implements Serializable {

    private Integer userTemperatureId;

    private Integer userId;

    private Float temperature;

    private LocalDateTime insertDate;

    public Integer getUserTemperatureId() {
        return userTemperatureId;
    }

    public void setUserTemperatureId(Integer userTemperatureId) {
        this.userTemperatureId = userTemperatureId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
    }
}
