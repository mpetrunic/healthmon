package hr.fer.zpr.marinpetrunic.healthmon.controllers.requests;

import hr.fer.zpr.marinpetrunic.healthmon.models.TemperatureModel;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author MarinPetrunic
 */
public class StoreTemperatureRequest implements Serializable {

    @NotNull
    @Min(36)
    @Max(42)
    private Float temperature;

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public TemperatureModel toTemperatureModel() {
        TemperatureModel model = new TemperatureModel();
        model.setTemperature(temperature);
        return model;
    }
}
