package hr.fer.zpr.marinpetrunic.healthmon.repositories;

import hr.fer.zpr.marinpetrunic.healthmon.models.BloodPressureModel;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author MarinPetrunic
 */
public interface IBloodPressureRepository {

    List<BloodPressureModel> getUsersBloodPressures(Integer userId, LocalDateTime from, LocalDateTime to);

    BloodPressureModel getBloodPressure(Integer bloodPressureId);

    BloodPressureModel store(BloodPressureModel bloodPressure);

    void delete(Integer bloodPressureId);
}
