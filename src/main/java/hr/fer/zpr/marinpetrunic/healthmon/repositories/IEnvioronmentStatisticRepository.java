package hr.fer.zpr.marinpetrunic.healthmon.repositories;

import hr.fer.zpr.marinpetrunic.healthmon.models.EnvioronmentStatisticModel;

import java.util.List;

/**
 * @author MarinPetrunic
 */
public interface IEnvioronmentStatisticRepository {

    List<EnvioronmentStatisticModel> all(Integer locationId);

    EnvioronmentStatisticModel store(EnvioronmentStatisticModel model);
}
