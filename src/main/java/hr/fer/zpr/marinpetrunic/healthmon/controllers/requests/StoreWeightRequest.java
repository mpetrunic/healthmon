package hr.fer.zpr.marinpetrunic.healthmon.controllers.requests;

import hr.fer.zpr.marinpetrunic.healthmon.models.WeightModel;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author MarinPetrunic
 */
public class StoreWeightRequest implements Serializable {

    @NotNull
    @Min(10)
    @Max(200)
    private Integer weight;


    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }


    public WeightModel toWeightModel() {
        WeightModel model = new WeightModel();
        model.setWeight(weight);
        return model;
    }

}
