package hr.fer.zpr.marinpetrunic.healthmon.models;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author MarinPetrunic
 */
public class WeightModel implements Serializable {

    private Integer userWeightId;

    private Integer userId;

    private Integer weight;

    private LocalDateTime insertDate;

    public Integer getUserWeightId() {
        return userWeightId;
    }

    public void setUserWeightId(Integer userWeightId) {
        this.userWeightId = userWeightId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
    }
}
