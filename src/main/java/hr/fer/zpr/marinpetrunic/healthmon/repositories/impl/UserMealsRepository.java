package hr.fer.zpr.marinpetrunic.healthmon.repositories.impl;

import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserMeal;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.UserMealRecord;
import hr.fer.zpr.marinpetrunic.healthmon.models.*;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.BaseRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IMealRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IMealTypeRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IUserMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author MarinPetrunic
 */
@Repository
public class UserMealsRepository extends BaseRepository implements IUserMealRepository{

    private static final UserMeal USER_MEAL = new UserMeal();

    @Autowired
    private IMealTypeRepository mealTypeRepository;

    @Autowired
    private IMealRepository mealRepository;

    private List<MealTypeModel> mealtypes;

    @PostConstruct
    public void initialize() {
        mealtypes = mealTypeRepository.all();
    }

    @Override
    public List<UserMealsByDayModel> all(Integer userId, LocalDate from, LocalDate to) {
        if(from == null) from = LocalDate.now().minusMonths(1);
        if(to == null) to = LocalDate.now().plusMonths(1);
        List<UserMealRecord> records = dsl.selectFrom(USER_MEAL)
                .where(USER_MEAL.USER_ID.equal(userId)
                        .and(USER_MEAL.INSERT_DATE.between(
                                Timestamp.valueOf(from.atStartOfDay()),
                                Timestamp.valueOf(to.plusDays(1).atStartOfDay()))))
                .orderBy(USER_MEAL.INSERT_DATE.asc(), USER_MEAL.MEAL_TYPE_ID.asc())
                .fetch();
        return toUserMealsByDay(records);
    }


    @Override
    public UserMealModel store(UserMealModel model) {
        UserMealRecord record = new UserMealRecord();
        model.setInsertDate(LocalDateTime.now());
        record.from(model);
        dsl.attach(record);
        record.store();
        model.setUserMealId(record.getUserMealId());
        return model;
    }

    @Override
    public void delete(Integer id) {
        dsl.deleteFrom(USER_MEAL).where(USER_MEAL.USER_MEAL_ID.equal(id)).execute();
    }

    private List<UserMealsByDayModel> toUserMealsByDay(List<UserMealRecord> records) {
        List<UserMealsByDayModel> meals = new ArrayList<>();
        if(records.isEmpty()) return meals;
        UserMealsByDayModel current = new UserMealsByDayModel();
        current.setDate(records.get(0).getInsertDate().toLocalDateTime().toLocalDate());
        for(UserMealRecord record : records) {
            if(record.getInsertDate().toLocalDateTime().toLocalDate().isAfter(current.getDate())) {
                meals.add(current);
                current = new UserMealsByDayModel();
                current.setDate(record.getInsertDate().toLocalDateTime().toLocalDate());
            }
            MealTypeModel type = getMealType(record.getMealTypeId());
            MealModel meal = mealRepository.get(record.getMealId());
            UserMealQuantityModel mealQuantity = new UserMealQuantityModel();
            mealQuantity.setMeal(meal);
            mealQuantity.setQuantity(record.getQuantity());
            if(current.getMeals().containsKey(type)) {
                current.getMeals().get(type).add(mealQuantity);
            } else {
                current.getMeals().put(type, new ArrayList<>(Arrays.asList(mealQuantity)));
            }
        }
        meals.add(current);
        return meals;
    }

    private MealTypeModel getMealType(Integer mealTypeId) {
        for(MealTypeModel type : mealtypes) {
            if(type.getMealTypeId().equals(mealTypeId)) return type;
        }
        return null;
    }
}
