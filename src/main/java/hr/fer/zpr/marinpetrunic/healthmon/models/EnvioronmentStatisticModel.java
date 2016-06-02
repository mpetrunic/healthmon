package hr.fer.zpr.marinpetrunic.healthmon.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author MarinPetrunic
 */
public class EnvioronmentStatisticModel implements Serializable {

    @JsonProperty(value = "id")
    private Integer environmentStatisticId;

    private Integer locationId;

    private Float temperature;

    private Float humidity;

    private Integer airPressure;

    private LocalDateTime insertDate;

    public Integer getEnvironmentStatisticId() {
        return environmentStatisticId;
    }

    public void setEnvironmentStatisticId(Integer environmentStatisticId) {
        this.environmentStatisticId = environmentStatisticId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Integer getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(Integer airPressure) {
        this.airPressure = airPressure;
    }

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
    }

}