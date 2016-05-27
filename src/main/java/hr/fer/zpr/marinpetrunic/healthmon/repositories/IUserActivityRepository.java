package hr.fer.zpr.marinpetrunic.healthmon.repositories;

import hr.fer.zpr.marinpetrunic.healthmon.models.UserActivityModel;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author MarinPetrunic
 */
public interface IUserActivityRepository {

    List<UserActivityModel> all(Integer userId, LocalDateTime from, LocalDateTime to);

    UserActivityModel get(Integer id);

    UserActivityModel store(UserActivityModel model);

    void delete(Integer id);
}
