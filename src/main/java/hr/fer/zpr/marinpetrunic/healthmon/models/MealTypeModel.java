package hr.fer.zpr.marinpetrunic.healthmon.models;

import java.io.Serializable;

/**
 * @author MarinPetrunic
 */
public class MealTypeModel implements Serializable {

    public MealTypeModel() {
    }

    public MealTypeModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public MealTypeModel(String name) {
        this.name = name;
    }

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
