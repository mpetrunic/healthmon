package hr.fer.zpr.marinpetrunic.healthmon.repositories.impl;

import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserWeight;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.UserWeightRecord;
import hr.fer.zpr.marinpetrunic.healthmon.models.WeightModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.BaseRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IWeightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author MarinPetrunic
 */
@Repository
public class WeightsRepository extends BaseRepository implements IWeightsRepository {

    private static final UserWeight USER_WEIGHT = new UserWeight();

    @Override
    public List<WeightModel> getUsersWeights(Integer userId, LocalDateTime from, LocalDateTime to) {
        if (from == null) from = LocalDateTime.now().minusYears(1);
        if (to == null) to = LocalDateTime.now().plusYears(1);
        return dsl.selectFrom(USER_WEIGHT)
                .where(
                        USER_WEIGHT.USER_ID.equal(userId)
                                .and(
                                        USER_WEIGHT.INSERT_DATE.ge(Timestamp.valueOf(from))
                                ).and(
                                USER_WEIGHT.INSERT_DATE.le(Timestamp.valueOf(to))
                        )
                ).orderBy(USER_WEIGHT.INSERT_DATE.asc())
                .fetch().into(WeightModel.class);
    }

    @Override
    public WeightModel getUserWeight(Integer id) {
        UserWeightRecord record = dsl.selectFrom(USER_WEIGHT).where(USER_WEIGHT.USER_WEIGHT_ID.equal(id)).fetchAny();
        if(record != null) {
            return record.into(WeightModel.class);
        }
        return null;
    }

    @Override
    public WeightModel store(WeightModel weightModel) {
        UserWeightRecord record = new UserWeightRecord();
        weightModel.setInsertDate(LocalDateTime.now());
        record.from(weightModel);
        dsl.attach(record);
        record.store();
        weightModel.setUserWeightId(record.getUserWeightId());
        return weightModel;
    }

    @Override
    public void delete(Integer id) {
        dsl.deleteFrom(USER_WEIGHT).where(USER_WEIGHT.USER_WEIGHT_ID.equal(id)).execute();
    }
}
