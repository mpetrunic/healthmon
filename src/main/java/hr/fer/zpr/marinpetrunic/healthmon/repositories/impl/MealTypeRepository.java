package hr.fer.zpr.marinpetrunic.healthmon.repositories.impl;

import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.MealType;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.MealTypeRecord;
import hr.fer.zpr.marinpetrunic.healthmon.models.MealTypeModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.BaseRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IMealTypeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MarinPetrunic
 */
@Repository
public class MealTypeRepository extends BaseRepository implements IMealTypeRepository {

    private static final MealType MEAL_TYPE = new MealType();

    @Override
    public List<MealTypeModel> all() {
        return dsl.selectFrom(MEAL_TYPE).fetch().into(MealTypeModel.class);
    }

    @Override
    public MealTypeModel get(String name) {
        MealTypeRecord record = dsl.selectFrom(MEAL_TYPE).where(MEAL_TYPE.NAME.equal(name)).fetchAny();
        if(record != null) {
            return record.into(MealTypeModel.class);
        }
        return null;
    }

    @Override
    public MealTypeModel get(Integer id) {
        MealTypeRecord record = dsl.selectFrom(MEAL_TYPE).where(MEAL_TYPE.MEAL_TYPE_ID.equal(id)).fetchAny();
        if(record != null) {
            return record.into(MealTypeModel.class);
        }
        return null;
    }

    @Override
    public MealTypeModel store(MealTypeModel model) {
        MealTypeRecord record = new MealTypeRecord();
        record.from(model);
        dsl.attach(record);
        record.store();
        model.setMealTypeId(record.getMealTypeId());
        return model;
    }
}
