package hr.fer.zpr.marinpetrunic.healthmon.repositories;

import hr.fer.zpr.marinpetrunic.healthmon.models.MealModel;

import java.util.List;

/**
 * @author MarinPetrunic
 */
public interface IMealRepository {

    List<MealModel> query(String query, Integer limit);

    MealModel get(Integer id);

    MealModel store(MealModel model);

    Integer size();

}
