package hr.fer.zpr.marinpetrunic.healthmon.repositories.impl;

import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserTemperature;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.UserTemperatureRecord;
import hr.fer.zpr.marinpetrunic.healthmon.models.TemperatureModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.BaseRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.ITemperatureRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author MarinPetrunic
 */
@Repository
public class TemperatureRepository extends BaseRepository implements ITemperatureRepository {

    private static final UserTemperature TEMPERATURE = new UserTemperature();

    @Override
    public List<TemperatureModel> getUserTemperatures(Integer userId, LocalDateTime from, LocalDateTime to) {
        if (from == null) from = LocalDateTime.now().minusYears(1);
        if (to == null) to = LocalDateTime.now().plusYears(1);
        return dsl.selectFrom(TEMPERATURE)
                .where(
                        TEMPERATURE.USER_ID.equal(userId)
                                .and(
                                        TEMPERATURE.INSERT_DATE.ge(Timestamp.valueOf(from))
                                ).and(
                                TEMPERATURE.INSERT_DATE.le(Timestamp.valueOf(to))
                        )
                ).orderBy(TEMPERATURE.INSERT_DATE.asc())
                .fetch().into(TemperatureModel.class);
    }

    @Override
    public TemperatureModel getTemperature(Integer id) {
        UserTemperatureRecord record = dsl.selectFrom(TEMPERATURE).where(TEMPERATURE.USER_TEMPERATURE_ID.equal(id)).fetchAny();
        if(record != null) {
            return record.into(TemperatureModel.class);
        }
        return null;
    }

    @Override
    public TemperatureModel store(TemperatureModel temperature) {
        UserTemperatureRecord record = new UserTemperatureRecord();
        temperature.setInsertDate(LocalDateTime.now());
        record.from(temperature);
        dsl.attach(record);
        record.store();
        temperature.setUserTemperatureId(record.getUserTemperatureId());
        return temperature;
    }

    @Override
    public void delete(Integer id) {
        dsl.deleteFrom(TEMPERATURE).where(TEMPERATURE.USER_TEMPERATURE_ID.equal(id)).execute();
    }
}
