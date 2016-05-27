package hr.fer.zpr.marinpetrunic.healthmon.repositories;

import hr.fer.zpr.marinpetrunic.healthmon.models.MealModel;

import java.util.List;

/**
 * @author MarinPetrunic
 */
public interface IMealRepository {

    public List<MealModel> query(String query, Integer limit);

    public MealModel store(MealModel model);

    public Integer size();

}
