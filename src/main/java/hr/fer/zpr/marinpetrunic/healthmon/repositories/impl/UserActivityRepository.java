package hr.fer.zpr.marinpetrunic.healthmon.repositories.impl;

import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserActivity;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.UserActivityRecord;
import hr.fer.zpr.marinpetrunic.healthmon.models.ActivityModel;
import hr.fer.zpr.marinpetrunic.healthmon.models.UserActivityModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.BaseRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IActivityRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IUserActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author MarinPetrunic
 */
@Repository
public class UserActivityRepository extends BaseRepository implements IUserActivityRepository {

    private static final UserActivity USER_ACTIVITY = new UserActivity();

    @Autowired
    private IActivityRepository activityRepository;

    @Override
    public List<UserActivityModel> all(Integer userId, LocalDateTime from, LocalDateTime to) {
        if(from == null) from = LocalDateTime.now().minusYears(1);
        if(to == null) to = LocalDateTime.now().plusYears(1);
        return dsl.selectFrom(USER_ACTIVITY)
                .where(USER_ACTIVITY.INSERT_DATE.between(
                        Timestamp.valueOf(from),
                        Timestamp.valueOf(to)
                )).orderBy(USER_ACTIVITY.INSERT_DATE)
                .fetch().into(UserActivityModel.class);
    }

    @Override
    public UserActivityModel get(Integer id) {
        UserActivityRecord record = dsl.selectFrom(USER_ACTIVITY).where(USER_ACTIVITY.USER_ACTIVITY_ID.equal(id)).fetchAny();
        if(record != null) {
            return record.into(UserActivityModel.class);
        }
        return null;
    }

    @Override
    public UserActivityModel store(UserActivityModel model) {
        UserActivityRecord record = new UserActivityRecord();
        model.setInsertDate(LocalDateTime.now());
        ActivityModel activity = activityRepository.get(model.getActivityId());
        Double calories = activity.getAverageCaloriesPerMin() * model.getActivityLenght();
        model.setCaloriesBurned(calories.intValue());
        record.from(model);
        dsl.attach(record);
        record.store();
        model.setUserActivityId(record.getUserActivityId());
        return model;
    }

    @Override
    public void delete(Integer id) {
        dsl.deleteFrom(USER_ACTIVITY).where(USER_ACTIVITY.USER_ACTIVITY_ID.equal(id)).execute();
    }
}
