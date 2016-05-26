package hr.fer.zpr.marinpetrunic.healthmon.repositories.impl;

import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserBloodPressure;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.UserBloodPressureRecord;
import hr.fer.zpr.marinpetrunic.healthmon.models.BloodPressureModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.BaseRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IBloodPressureRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author MarinPetrunic
 */
@Repository
public class BloodPressureRepository extends BaseRepository implements IBloodPressureRepository {

    private static UserBloodPressure BLOOD_PRESSURE = new UserBloodPressure();

    @Override
    public List<BloodPressureModel> getUsersBloodPressures(Integer userId, LocalDateTime from, LocalDateTime to) {
        if (from == null) from = LocalDateTime.now().minusYears(1);
        if (to == null) to = LocalDateTime.now().plusYears(1);
        return dsl.selectFrom(BLOOD_PRESSURE)
                .where(
                        BLOOD_PRESSURE.USER_ID.equal(userId)
                                .and(
                                        BLOOD_PRESSURE.INSERT_DATE.ge(Timestamp.valueOf(from))
                                ).and(
                                BLOOD_PRESSURE.INSERT_DATE.le(Timestamp.valueOf(to))
                        )
                ).orderBy(BLOOD_PRESSURE.INSERT_DATE.asc())
                .fetch().into(BloodPressureModel.class);
    }

    @Override
    public BloodPressureModel getBloodPressure(Integer bloodPressureId) {
        UserBloodPressureRecord record = dsl.selectFrom(BLOOD_PRESSURE).where(BLOOD_PRESSURE.USER_BLOOD_PRESSURE_ID.equal(bloodPressureId)).fetchAny();
        if(record != null) {
            return record.into(BloodPressureModel.class);
        }
        return null;
    }

    @Override
    @Transactional
    public BloodPressureModel store(BloodPressureModel bloodPressure) {
        UserBloodPressureRecord record = new UserBloodPressureRecord();
        bloodPressure.setInsertDate(LocalDateTime.now());
        record.from(bloodPressure);
        dsl.attach(record);
        record.store();
        bloodPressure.setUserBloodPressureId(record.getUserBloodPressureId());
        return bloodPressure;
    }

    @Override
    public void delete(Integer bloodPressureId) {
        dsl.deleteFrom(BLOOD_PRESSURE).where(BLOOD_PRESSURE.USER_BLOOD_PRESSURE_ID.equal(bloodPressureId)).execute();
    }
}
