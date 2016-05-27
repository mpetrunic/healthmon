package hr.fer.zpr.marinpetrunic.healthmon.models.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author MarinPetrunic
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinates implements Serializable {

    private Double lon;

    private Double lat;

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
