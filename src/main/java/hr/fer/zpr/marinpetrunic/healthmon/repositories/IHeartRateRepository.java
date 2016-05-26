package hr.fer.zpr.marinpetrunic.healthmon.repositories;

import hr.fer.zpr.marinpetrunic.healthmon.models.HeartRateModel;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author MarinPetrunic
 */
public interface IHeartRateRepository {

    List<HeartRateModel> getUsersHeartRates(Integer userId, LocalDateTime from, LocalDateTime to);

    HeartRateModel getHeartRate(Integer heartRateId);

    @Transactional
    HeartRateModel store(HeartRateModel heartRate);

    void delete(Integer heartRateId);
}
