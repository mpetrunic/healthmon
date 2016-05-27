package hr.fer.zpr.marinpetrunic.healthmon.repositories;

import hr.fer.zpr.marinpetrunic.healthmon.models.MealTypeModel;

import java.util.List;

/**
 * @author MarinPetrunic
 */
public interface IMealTypeRepository {

    List<MealTypeModel> all();

    MealTypeModel get(String name);

    MealTypeModel get(Integer id);

    MealTypeModel store(MealTypeModel model);
}
