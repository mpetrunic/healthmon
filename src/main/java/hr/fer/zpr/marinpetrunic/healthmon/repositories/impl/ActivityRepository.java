package hr.fer.zpr.marinpetrunic.healthmon.repositories.impl;

import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.Activity;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.ActivityRecord;
import hr.fer.zpr.marinpetrunic.healthmon.models.ActivityModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.BaseRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IActivityRepository;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MarinPetrunic
 */
@Repository
public class ActivityRepository extends BaseRepository implements IActivityRepository {

    private static final Activity ACTIVITY = new Activity();

    @Autowired
    private DSLContext dsl;

    @Override
    public List<ActivityModel> all() {
        return dsl.selectFrom(ACTIVITY).fetch().into(ActivityModel.class);
    }

    @Override
    public ActivityModel store(ActivityModel model) {
        ActivityRecord record = new ActivityRecord();
        record.from(model);
        dsl.attach(record);
        record.store();
        model.setId(record.getId());
        return model;
    }
}
