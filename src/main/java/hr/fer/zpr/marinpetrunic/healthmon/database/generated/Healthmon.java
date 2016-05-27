/**
 * This class is generated by jOOQ
 */
package hr.fer.zpr.marinpetrunic.healthmon.database.generated;


import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.Activity;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.EnvironmentStatistic;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.Location;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.Meal;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.MealType;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.SchemaVersion;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.User;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserActivity;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserBloodPressure;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserHeartRate;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserMeal;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserRole;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserTemperature;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserWeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Healthmon extends SchemaImpl {

	private static final long serialVersionUID = -1820115141;

	/**
	 * The reference instance of <code>healthmon</code>
	 */
	public static final Healthmon HEALTHMON = new Healthmon();

	/**
	 * No further instances allowed
	 */
	private Healthmon() {
		super("healthmon");
	}

	@Override
	public final List<Table<?>> getTables() {
		List result = new ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final List<Table<?>> getTables0() {
		return Arrays.<Table<?>>asList(
			Activity.ACTIVITY,
			EnvironmentStatistic.ENVIRONMENT_STATISTIC,
			Location.LOCATION,
			Meal.MEAL,
			MealType.MEAL_TYPE,
			SchemaVersion.SCHEMA_VERSION,
			User.USER,
			UserActivity.USER_ACTIVITY,
			UserBloodPressure.USER_BLOOD_PRESSURE,
			UserHeartRate.USER_HEART_RATE,
			UserMeal.USER_MEAL,
			UserRole.USER_ROLE,
			UserTemperature.USER_TEMPERATURE,
			UserWeight.USER_WEIGHT);
	}
}
