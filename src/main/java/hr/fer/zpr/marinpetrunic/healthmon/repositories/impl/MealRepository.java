package hr.fer.zpr.marinpetrunic.healthmon.repositories.impl;

import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.Meal;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.MealRecord;
import hr.fer.zpr.marinpetrunic.healthmon.models.MealModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.BaseRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IMealRepository;
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
    public MealModel get(Integer id) {
        MealRecord record = dsl.selectFrom(MEAL).where(MEAL.MEAL_ID.equal(id)).fetchAny();
        if(record != null) {
            return record.into(MealModel.class);
        }
        return null;
    }

    @Override
    public MealModel store(MealModel model) {
        MealRecord record = new MealRecord();
        record.from(model);
        dsl.attach(record);
        record.store();
        model.setMealId(record.getMealId());
        return model;
    }

    @Override
    public Integer size() {
        return dsl.selectCount().from(MEAL).fetchOne(0, int.class);
    }
}
