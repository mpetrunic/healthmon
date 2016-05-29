package hr.fer.zpr.marinpetrunic.healthmon.repositories.impl;

import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.EnvironmentStatistic;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.EnvironmentStatisticRecord;
import hr.fer.zpr.marinpetrunic.healthmon.models.EnvioronmentStatisticModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.BaseRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IEnvioronmentStatisticRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author MarinPetrunic
 */
@Repository
public class EnvioronmentStatisticRepository extends BaseRepository implements IEnvioronmentStatisticRepository {

    private static final EnvironmentStatistic ENVIRONMENT_STATISTIC = new EnvironmentStatistic();

    @Override
    public List<EnvioronmentStatisticModel> all(Integer locationId) {
        return dsl
                .selectFrom(ENVIRONMENT_STATISTIC)
                .where(ENVIRONMENT_STATISTIC.LOCATION_ID.equal(locationId)
                    .and(ENVIRONMENT_STATISTIC.INSERT_DATE
                        .between(Timestamp.valueOf(LocalDateTime.now().minusMonths(1)),
                            Timestamp.valueOf(LocalDateTime.now()))))
                .fetch().into(EnvioronmentStatisticModel.class);
    }

    @Override
    public EnvioronmentStatisticModel store(EnvioronmentStatisticModel model) {
        EnvironmentStatisticRecord record = new EnvironmentStatisticRecord();
        model.setInsertDate(LocalDateTime.now());
        record.from(model);
        dsl.attach(record);
        record.store();
        model.setId(record.getId());
        return model;
    }
}
