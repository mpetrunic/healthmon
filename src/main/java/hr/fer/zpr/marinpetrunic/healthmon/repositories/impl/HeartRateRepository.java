package hr.fer.zpr.marinpetrunic.healthmon.repositories.impl;

import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserHeartRate;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.UserHeartRateRecord;
import hr.fer.zpr.marinpetrunic.healthmon.models.HeartRateModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.BaseRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IHeartRateRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author MarinPetrunic
 */
@Repository
public class HeartRateRepository extends BaseRepository implements IHeartRateRepository {

    private static final UserHeartRate HEART_RATE = new UserHeartRate();

    @Override
    public List<HeartRateModel> getUsersHeartRates(Integer userId, LocalDateTime from, LocalDateTime to) {
        if (from == null) from = LocalDateTime.now().minusYears(1);
        if (to == null) to = LocalDateTime.now().plusYears(1);
        return dsl.selectFrom(HEART_RATE)
                .where(
                        HEART_RATE.USER_ID.equal(userId)
                                .and(
                                        HEART_RATE.INSERT_DATE.ge(Timestamp.valueOf(from))
                                ).and(
                                HEART_RATE.INSERT_DATE.le(Timestamp.valueOf(to))
                        )
                ).orderBy(HEART_RATE.INSERT_DATE.asc())
                .fetch().into(HeartRateModel.class);
    }

    @Override
    public HeartRateModel getHeartRate(Integer heartRateId) {
        UserHeartRateRecord record = dsl.selectFrom(HEART_RATE).where(HEART_RATE.USER_HEART_RATE_ID.equal(heartRateId)).fetchAny();
        if(record != null) {
            return record.into(HeartRateModel.class);
        }
        return null;
    }

    @Override
    public HeartRateModel store(HeartRateModel heartRate) {
        UserHeartRateRecord record = new UserHeartRateRecord();
        heartRate.setInsertDate(LocalDateTime.now());
        record.from(heartRate);
        dsl.attach(record);
        record.store();
        heartRate.setUserHeartRateId(record.getUserHeartRateId());
        return heartRate;
    }

    @Override
    public void delete(Integer heartRateId) {
        dsl.deleteFrom(HEART_RATE).where(HEART_RATE.USER_HEART_RATE_ID.equal(heartRateId)).execute();
    }
}
