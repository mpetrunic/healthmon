package hr.fer.zpr.marinpetrunic.healthmon.repositories;

import hr.fer.zpr.marinpetrunic.healthmon.models.TemperatureModel;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author MarinPetrunic
 */
public interface ITemperatureRepository {

    List<TemperatureModel> getUserTemperatures(Integer userId, LocalDateTime from, LocalDateTime to);

    TemperatureModel getTemperature(Integer id);

    @Transactional
    TemperatureModel store(TemperatureModel temperature);

    void delete(Integer id);
}
