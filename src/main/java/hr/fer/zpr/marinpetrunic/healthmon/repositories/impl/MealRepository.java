package hr.fer.zpr.marinpetrunic.healthmon.repositories.impl;

import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.Meal;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.MealRecord;
import hr.fer.zpr.marinpetrunic.healthmon.models.MealModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.BaseRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IMealRepository;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MarinPetrunic
 */
@Repository
public class MealRepository extends BaseRepository implements IMealRepository {

    private static final Meal MEAL = new Meal();

    @Override
    public List<MealModel> query(String query, Integer limit) {
        return dsl.selectFrom(MEAL).where(MEAL.NAME.like(query+"%")).limit(limit).fetch().into(MealModel.class);
    }

    @Override
    public MealModel store(MealModel model) {
        MealRecord record = new MealRecord();
        record.from(model);
        dsl.attach(record);
        record.store();
        model.setId(record.getId());
        return model;
    }

    @Override
    public Integer size() {
        return dsl.selectCount().from(MEAL).fetchOne(0, int.class);
    }
}
