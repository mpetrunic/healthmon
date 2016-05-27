package hr.fer.zpr.marinpetrunic.healthmon.repositories;

import hr.fer.zpr.marinpetrunic.healthmon.models.WeightModel;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author MarinPetrunic
 */
public interface IWeightsRepository {

    List<WeightModel> getUsersWeights(Integer userId, LocalDateTime from, LocalDateTime to);

    WeightModel getUserWeight(Integer id);

    @Transactional
    WeightModel store(WeightModel weightModel);

    void delete(Integer id);

}
