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

import javax.annotation.Generated;


/**
 * Convenience access to all tables in healthmon
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

	/**
	 * The table healthmon.activity
	 */
	public static final Activity ACTIVITY = hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.Activity.ACTIVITY;

	/**
	 * The table healthmon.environment_statistic
	 */
	public static final EnvironmentStatistic ENVIRONMENT_STATISTIC = hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.EnvironmentStatistic.ENVIRONMENT_STATISTIC;

	/**
	 * The table healthmon.location
	 */
	public static final Location LOCATION = hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.Location.LOCATION;

	/**
	 * The table healthmon.meal
	 */
	public static final Meal MEAL = hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.Meal.MEAL;

	/**
	 * The table healthmon.meal_type
	 */
	public static final MealType MEAL_TYPE = hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.MealType.MEAL_TYPE;

	/**
	 * The table healthmon.schema_version
	 */
	public static final SchemaVersion SCHEMA_VERSION = hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.SchemaVersion.SCHEMA_VERSION;

	/**
	 * The table healthmon.user
	 */
	public static final User USER = hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.User.USER;

	/**
	 * The table healthmon.user_activity
	 */
	public static final UserActivity USER_ACTIVITY = hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserActivity.USER_ACTIVITY;

	/**
	 * The table healthmon.user_blood_pressure
	 */
	public static final UserBloodPressure USER_BLOOD_PRESSURE = hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserBloodPressure.USER_BLOOD_PRESSURE;

	/**
	 * The table healthmon.user_heart_rate
	 */
	public static final UserHeartRate USER_HEART_RATE = hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserHeartRate.USER_HEART_RATE;

	/**
	 * The table healthmon.user_meal
	 */
	public static final UserMeal USER_MEAL = hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserMeal.USER_MEAL;

	/**
	 * The table healthmon.user_role
	 */
	public static final UserRole USER_ROLE = hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserRole.USER_ROLE;

	/**
	 * The table healthmon.user_temperature
	 */
	public static final UserTemperature USER_TEMPERATURE = hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserTemperature.USER_TEMPERATURE;

	/**
	 * The table healthmon.user_weight
	 */
	public static final UserWeight USER_WEIGHT = hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserWeight.USER_WEIGHT;
}
