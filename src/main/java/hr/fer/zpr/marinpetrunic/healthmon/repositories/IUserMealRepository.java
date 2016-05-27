package hr.fer.zpr.marinpetrunic.healthmon.repositories;

import hr.fer.zpr.marinpetrunic.healthmon.models.UserMealModel;
import hr.fer.zpr.marinpetrunic.healthmon.models.UserMealsByDayModel;

import java.time.LocalDate;
import java.util.List;

/**
 * @author MarinPetrunic
 */
public interface IUserMealRepository {

    List<UserMealsByDayModel> all(LocalDate from, LocalDate to);

    UserMealModel store(UserMealModel model);

    void delete(Integer id);
}
