package hr.fer.zpr.marinpetrunic.healthmon.models.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hr.fer.zpr.marinpetrunic.healthmon.models.EnvioronmentStatisticModel;

import java.io.Serializable;

/**
 * @author MarinPetrunic
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherResponse implements Serializable {

    private Coordinates coord;

    private String base;

    private MainData main;

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public MainData getMain() {
        return main;
    }

    public void setMain(MainData main) {
        this.main = main;
    }

    public EnvioronmentStatisticModel toEnvioronmentStatisticModel(){
        EnvioronmentStatisticModel model = new EnvioronmentStatisticModel();
        model.setAirPressure(this.getMain().getPressure().intValue());
        model.setHumidity(this.getMain().getHumidity().floatValue());
        model.setTemperature(this.getMain().getTemp().floatValue());
        return model;
    }

    @Override
    public String toString() {
        return "OpenWeatherResponse{" +
                "coord=" + coord +
                ", base='" + base + '\'' +
                ", main=" + main +
                '}';
    }
}
