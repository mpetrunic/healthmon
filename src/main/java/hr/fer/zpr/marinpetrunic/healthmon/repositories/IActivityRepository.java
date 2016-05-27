package hr.fer.zpr.marinpetrunic.healthmon.repositories;

import hr.fer.zpr.marinpetrunic.healthmon.models.ActivityModel;

import java.util.List;

/**
 * @author MarinPetrunic
 */
public interface IActivityRepository {

    List<ActivityModel> all();

    ActivityModel store(ActivityModel model);

}
