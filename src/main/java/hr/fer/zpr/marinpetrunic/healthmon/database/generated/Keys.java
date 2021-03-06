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
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserTemperature;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserWeight;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.ActivityRecord;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.EnvironmentStatisticRecord;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.LocationRecord;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.MealRecord;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.MealTypeRecord;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.SchemaVersionRecord;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.UserActivityRecord;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.UserBloodPressureRecord;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.UserHeartRateRecord;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.UserMealRecord;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.UserRecord;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.UserTemperatureRecord;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.UserWeightRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships between tables of the <code>healthmon</code> 
 * schema
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

	// -------------------------------------------------------------------------
	// IDENTITY definitions
	// -------------------------------------------------------------------------

	public static final Identity<LocationRecord, Integer> IDENTITY_LOCATION = Identities0.IDENTITY_LOCATION;
	public static final Identity<UserRecord, Integer> IDENTITY_USER = Identities0.IDENTITY_USER;
	public static final Identity<UserActivityRecord, Integer> IDENTITY_USER_ACTIVITY = Identities0.IDENTITY_USER_ACTIVITY;
	public static final Identity<UserBloodPressureRecord, Integer> IDENTITY_USER_BLOOD_PRESSURE = Identities0.IDENTITY_USER_BLOOD_PRESSURE;
	public static final Identity<UserHeartRateRecord, Integer> IDENTITY_USER_HEART_RATE = Identities0.IDENTITY_USER_HEART_RATE;
	public static final Identity<UserMealRecord, Integer> IDENTITY_USER_MEAL = Identities0.IDENTITY_USER_MEAL;
	public static final Identity<UserTemperatureRecord, Integer> IDENTITY_USER_TEMPERATURE = Identities0.IDENTITY_USER_TEMPERATURE;
	public static final Identity<UserWeightRecord, Integer> IDENTITY_USER_WEIGHT = Identities0.IDENTITY_USER_WEIGHT;

	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final UniqueKey<ActivityRecord> KEY_ACTIVITY_PRIMARY = UniqueKeys0.KEY_ACTIVITY_PRIMARY;
	public static final UniqueKey<ActivityRecord> KEY_ACTIVITY_ID_UNIQUE = UniqueKeys0.KEY_ACTIVITY_ID_UNIQUE;
	public static final UniqueKey<EnvironmentStatisticRecord> KEY_ENVIRONMENT_STATISTIC_PRIMARY = UniqueKeys0.KEY_ENVIRONMENT_STATISTIC_PRIMARY;
	public static final UniqueKey<EnvironmentStatisticRecord> KEY_ENVIRONMENT_STATISTIC_ID_UNIQUE = UniqueKeys0.KEY_ENVIRONMENT_STATISTIC_ID_UNIQUE;
	public static final UniqueKey<LocationRecord> KEY_LOCATION_PRIMARY = UniqueKeys0.KEY_LOCATION_PRIMARY;
	public static final UniqueKey<LocationRecord> KEY_LOCATION_ID_UNIQUE = UniqueKeys0.KEY_LOCATION_ID_UNIQUE;
	public static final UniqueKey<LocationRecord> KEY_LOCATION_CITY_NAME_UNIQUE = UniqueKeys0.KEY_LOCATION_CITY_NAME_UNIQUE;
	public static final UniqueKey<MealRecord> KEY_MEAL_PRIMARY = UniqueKeys0.KEY_MEAL_PRIMARY;
	public static final UniqueKey<MealRecord> KEY_MEAL_ID_UNIQUE = UniqueKeys0.KEY_MEAL_ID_UNIQUE;
	public static final UniqueKey<MealTypeRecord> KEY_MEAL_TYPE_PRIMARY = UniqueKeys0.KEY_MEAL_TYPE_PRIMARY;
	public static final UniqueKey<MealTypeRecord> KEY_MEAL_TYPE_ID_UNIQUE = UniqueKeys0.KEY_MEAL_TYPE_ID_UNIQUE;
	public static final UniqueKey<MealTypeRecord> KEY_MEAL_TYPE_NAME_UNIQUE = UniqueKeys0.KEY_MEAL_TYPE_NAME_UNIQUE;
	public static final UniqueKey<SchemaVersionRecord> KEY_SCHEMA_VERSION_PRIMARY = UniqueKeys0.KEY_SCHEMA_VERSION_PRIMARY;
	public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = UniqueKeys0.KEY_USER_PRIMARY;
	public static final UniqueKey<UserRecord> KEY_USER_ID_UNIQUE = UniqueKeys0.KEY_USER_ID_UNIQUE;
	public static final UniqueKey<UserRecord> KEY_USER_USERNAME_UNIQUE = UniqueKeys0.KEY_USER_USERNAME_UNIQUE;
	public static final UniqueKey<UserRecord> KEY_USER_EMAIL_UNIQUE = UniqueKeys0.KEY_USER_EMAIL_UNIQUE;
	public static final UniqueKey<UserActivityRecord> KEY_USER_ACTIVITY_PRIMARY = UniqueKeys0.KEY_USER_ACTIVITY_PRIMARY;
	public static final UniqueKey<UserActivityRecord> KEY_USER_ACTIVITY_ID_UNIQUE = UniqueKeys0.KEY_USER_ACTIVITY_ID_UNIQUE;
	public static final UniqueKey<UserBloodPressureRecord> KEY_USER_BLOOD_PRESSURE_PRIMARY = UniqueKeys0.KEY_USER_BLOOD_PRESSURE_PRIMARY;
	public static final UniqueKey<UserBloodPressureRecord> KEY_USER_BLOOD_PRESSURE_USER_HEART_PRESSURE_ID_UNIQUE = UniqueKeys0.KEY_USER_BLOOD_PRESSURE_USER_HEART_PRESSURE_ID_UNIQUE;
	public static final UniqueKey<UserHeartRateRecord> KEY_USER_HEART_RATE_PRIMARY = UniqueKeys0.KEY_USER_HEART_RATE_PRIMARY;
	public static final UniqueKey<UserHeartRateRecord> KEY_USER_HEART_RATE_USER_HEART_RATE_ID_UNIQUE = UniqueKeys0.KEY_USER_HEART_RATE_USER_HEART_RATE_ID_UNIQUE;
	public static final UniqueKey<UserMealRecord> KEY_USER_MEAL_PRIMARY = UniqueKeys0.KEY_USER_MEAL_PRIMARY;
	public static final UniqueKey<UserMealRecord> KEY_USER_MEAL_ID_UNIQUE = UniqueKeys0.KEY_USER_MEAL_ID_UNIQUE;
	public static final UniqueKey<UserTemperatureRecord> KEY_USER_TEMPERATURE_PRIMARY = UniqueKeys0.KEY_USER_TEMPERATURE_PRIMARY;
	public static final UniqueKey<UserTemperatureRecord> KEY_USER_TEMPERATURE_USER_TEMPERATURE_ID_UNIQUE = UniqueKeys0.KEY_USER_TEMPERATURE_USER_TEMPERATURE_ID_UNIQUE;
	public static final UniqueKey<UserWeightRecord> KEY_USER_WEIGHT_PRIMARY = UniqueKeys0.KEY_USER_WEIGHT_PRIMARY;
	public static final UniqueKey<UserWeightRecord> KEY_USER_WEIGHT_USER_WEIGHT_ID_UNIQUE = UniqueKeys0.KEY_USER_WEIGHT_USER_WEIGHT_ID_UNIQUE;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------

	public static final ForeignKey<EnvironmentStatisticRecord, LocationRecord> FK_ENVIROMENT_STATISTIC_LOCATION1 = ForeignKeys0.FK_ENVIROMENT_STATISTIC_LOCATION1;
	public static final ForeignKey<UserRecord, LocationRecord> FK_USER_LOCATION1 = ForeignKeys0.FK_USER_LOCATION1;
	public static final ForeignKey<UserActivityRecord, UserRecord> FK_USER_ACTIVITY_USER1 = ForeignKeys0.FK_USER_ACTIVITY_USER1;
	public static final ForeignKey<UserActivityRecord, ActivityRecord> FK_USER_ACTIVITY_ACTIVITY2 = ForeignKeys0.FK_USER_ACTIVITY_ACTIVITY2;
	public static final ForeignKey<UserBloodPressureRecord, UserRecord> FK_USER_BLOOD_PRESSURE_USER1 = ForeignKeys0.FK_USER_BLOOD_PRESSURE_USER1;
	public static final ForeignKey<UserHeartRateRecord, UserRecord> FK_USER_HEART_RATE_USER1 = ForeignKeys0.FK_USER_HEART_RATE_USER1;
	public static final ForeignKey<UserMealRecord, UserRecord> FK_USER_MEAL_USER1 = ForeignKeys0.FK_USER_MEAL_USER1;
	public static final ForeignKey<UserMealRecord, MealTypeRecord> FK_USER_MEAL_MEAL_TYPE1 = ForeignKeys0.FK_USER_MEAL_MEAL_TYPE1;
	public static final ForeignKey<UserMealRecord, MealRecord> FK_USER_MEAL_MEAL1 = ForeignKeys0.FK_USER_MEAL_MEAL1;
	public static final ForeignKey<UserTemperatureRecord, UserRecord> FK_USER_TEMPERATURE_USER1 = ForeignKeys0.FK_USER_TEMPERATURE_USER1;
	public static final ForeignKey<UserWeightRecord, UserRecord> FK_USER_WEIGHT_USER1 = ForeignKeys0.FK_USER_WEIGHT_USER1;

	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class Identities0 extends AbstractKeys {
		public static Identity<LocationRecord, Integer> IDENTITY_LOCATION = createIdentity(Location.LOCATION, Location.LOCATION.ID);
		public static Identity<UserRecord, Integer> IDENTITY_USER = createIdentity(User.USER, User.USER.ID);
		public static Identity<UserActivityRecord, Integer> IDENTITY_USER_ACTIVITY = createIdentity(UserActivity.USER_ACTIVITY, UserActivity.USER_ACTIVITY.USER_ACTIVITY_ID);
		public static Identity<UserBloodPressureRecord, Integer> IDENTITY_USER_BLOOD_PRESSURE = createIdentity(UserBloodPressure.USER_BLOOD_PRESSURE, UserBloodPressure.USER_BLOOD_PRESSURE.USER_BLOOD_PRESSURE_ID);
		public static Identity<UserHeartRateRecord, Integer> IDENTITY_USER_HEART_RATE = createIdentity(UserHeartRate.USER_HEART_RATE, UserHeartRate.USER_HEART_RATE.USER_HEART_RATE_ID);
		public static Identity<UserMealRecord, Integer> IDENTITY_USER_MEAL = createIdentity(UserMeal.USER_MEAL, UserMeal.USER_MEAL.USER_MEAL_ID);
		public static Identity<UserTemperatureRecord, Integer> IDENTITY_USER_TEMPERATURE = createIdentity(UserTemperature.USER_TEMPERATURE, UserTemperature.USER_TEMPERATURE.USER_TEMPERATURE_ID);
		public static Identity<UserWeightRecord, Integer> IDENTITY_USER_WEIGHT = createIdentity(UserWeight.USER_WEIGHT, UserWeight.USER_WEIGHT.USER_WEIGHT_ID);
	}

	private static class UniqueKeys0 extends AbstractKeys {
		public static final UniqueKey<ActivityRecord> KEY_ACTIVITY_PRIMARY = createUniqueKey(Activity.ACTIVITY, Activity.ACTIVITY.ACTIVITY_ID);
		public static final UniqueKey<ActivityRecord> KEY_ACTIVITY_ID_UNIQUE = createUniqueKey(Activity.ACTIVITY, Activity.ACTIVITY.ACTIVITY_ID);
		public static final UniqueKey<EnvironmentStatisticRecord> KEY_ENVIRONMENT_STATISTIC_PRIMARY = createUniqueKey(EnvironmentStatistic.ENVIRONMENT_STATISTIC, EnvironmentStatistic.ENVIRONMENT_STATISTIC.ENVIRONMENT_STATISTIC_ID);
		public static final UniqueKey<EnvironmentStatisticRecord> KEY_ENVIRONMENT_STATISTIC_ID_UNIQUE = createUniqueKey(EnvironmentStatistic.ENVIRONMENT_STATISTIC, EnvironmentStatistic.ENVIRONMENT_STATISTIC.ENVIRONMENT_STATISTIC_ID);
		public static final UniqueKey<LocationRecord> KEY_LOCATION_PRIMARY = createUniqueKey(Location.LOCATION, Location.LOCATION.ID);
		public static final UniqueKey<LocationRecord> KEY_LOCATION_ID_UNIQUE = createUniqueKey(Location.LOCATION, Location.LOCATION.ID);
		public static final UniqueKey<LocationRecord> KEY_LOCATION_CITY_NAME_UNIQUE = createUniqueKey(Location.LOCATION, Location.LOCATION.CITY_NAME);
		public static final UniqueKey<MealRecord> KEY_MEAL_PRIMARY = createUniqueKey(Meal.MEAL, Meal.MEAL.MEAL_ID);
		public static final UniqueKey<MealRecord> KEY_MEAL_ID_UNIQUE = createUniqueKey(Meal.MEAL, Meal.MEAL.MEAL_ID);
		public static final UniqueKey<MealTypeRecord> KEY_MEAL_TYPE_PRIMARY = createUniqueKey(MealType.MEAL_TYPE, MealType.MEAL_TYPE.MEAL_TYPE_ID);
		public static final UniqueKey<MealTypeRecord> KEY_MEAL_TYPE_ID_UNIQUE = createUniqueKey(MealType.MEAL_TYPE, MealType.MEAL_TYPE.MEAL_TYPE_ID);
		public static final UniqueKey<MealTypeRecord> KEY_MEAL_TYPE_NAME_UNIQUE = createUniqueKey(MealType.MEAL_TYPE, MealType.MEAL_TYPE.NAME);
		public static final UniqueKey<SchemaVersionRecord> KEY_SCHEMA_VERSION_PRIMARY = createUniqueKey(SchemaVersion.SCHEMA_VERSION, SchemaVersion.SCHEMA_VERSION.INSTALLED_RANK);
		public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = createUniqueKey(User.USER, User.USER.ID);
		public static final UniqueKey<UserRecord> KEY_USER_ID_UNIQUE = createUniqueKey(User.USER, User.USER.ID);
		public static final UniqueKey<UserRecord> KEY_USER_USERNAME_UNIQUE = createUniqueKey(User.USER, User.USER.USERNAME);
		public static final UniqueKey<UserRecord> KEY_USER_EMAIL_UNIQUE = createUniqueKey(User.USER, User.USER.EMAIL);
		public static final UniqueKey<UserActivityRecord> KEY_USER_ACTIVITY_PRIMARY = createUniqueKey(UserActivity.USER_ACTIVITY, UserActivity.USER_ACTIVITY.USER_ACTIVITY_ID);
		public static final UniqueKey<UserActivityRecord> KEY_USER_ACTIVITY_ID_UNIQUE = createUniqueKey(UserActivity.USER_ACTIVITY, UserActivity.USER_ACTIVITY.USER_ACTIVITY_ID);
		public static final UniqueKey<UserBloodPressureRecord> KEY_USER_BLOOD_PRESSURE_PRIMARY = createUniqueKey(UserBloodPressure.USER_BLOOD_PRESSURE, UserBloodPressure.USER_BLOOD_PRESSURE.USER_BLOOD_PRESSURE_ID);
		public static final UniqueKey<UserBloodPressureRecord> KEY_USER_BLOOD_PRESSURE_USER_HEART_PRESSURE_ID_UNIQUE = createUniqueKey(UserBloodPressure.USER_BLOOD_PRESSURE, UserBloodPressure.USER_BLOOD_PRESSURE.USER_BLOOD_PRESSURE_ID);
		public static final UniqueKey<UserHeartRateRecord> KEY_USER_HEART_RATE_PRIMARY = createUniqueKey(UserHeartRate.USER_HEART_RATE, UserHeartRate.USER_HEART_RATE.USER_HEART_RATE_ID);
		public static final UniqueKey<UserHeartRateRecord> KEY_USER_HEART_RATE_USER_HEART_RATE_ID_UNIQUE = createUniqueKey(UserHeartRate.USER_HEART_RATE, UserHeartRate.USER_HEART_RATE.USER_HEART_RATE_ID);
		public static final UniqueKey<UserMealRecord> KEY_USER_MEAL_PRIMARY = createUniqueKey(UserMeal.USER_MEAL, UserMeal.USER_MEAL.USER_MEAL_ID);
		public static final UniqueKey<UserMealRecord> KEY_USER_MEAL_ID_UNIQUE = createUniqueKey(UserMeal.USER_MEAL, UserMeal.USER_MEAL.USER_MEAL_ID);
		public static final UniqueKey<UserTemperatureRecord> KEY_USER_TEMPERATURE_PRIMARY = createUniqueKey(UserTemperature.USER_TEMPERATURE, UserTemperature.USER_TEMPERATURE.USER_TEMPERATURE_ID);
		public static final UniqueKey<UserTemperatureRecord> KEY_USER_TEMPERATURE_USER_TEMPERATURE_ID_UNIQUE = createUniqueKey(UserTemperature.USER_TEMPERATURE, UserTemperature.USER_TEMPERATURE.USER_TEMPERATURE_ID);
		public static final UniqueKey<UserWeightRecord> KEY_USER_WEIGHT_PRIMARY = createUniqueKey(UserWeight.USER_WEIGHT, UserWeight.USER_WEIGHT.USER_WEIGHT_ID);
		public static final UniqueKey<UserWeightRecord> KEY_USER_WEIGHT_USER_WEIGHT_ID_UNIQUE = createUniqueKey(UserWeight.USER_WEIGHT, UserWeight.USER_WEIGHT.USER_WEIGHT_ID);
	}

	private static class ForeignKeys0 extends AbstractKeys {
		public static final ForeignKey<EnvironmentStatisticRecord, LocationRecord> FK_ENVIROMENT_STATISTIC_LOCATION1 = createForeignKey(hr.fer.zpr.marinpetrunic.healthmon.database.generated.Keys.KEY_LOCATION_PRIMARY, EnvironmentStatistic.ENVIRONMENT_STATISTIC, EnvironmentStatistic.ENVIRONMENT_STATISTIC.LOCATION_ID);
		public static final ForeignKey<UserRecord, LocationRecord> FK_USER_LOCATION1 = createForeignKey(hr.fer.zpr.marinpetrunic.healthmon.database.generated.Keys.KEY_LOCATION_PRIMARY, User.USER, User.USER.LOCATION_ID);
		public static final ForeignKey<UserActivityRecord, UserRecord> FK_USER_ACTIVITY_USER1 = createForeignKey(hr.fer.zpr.marinpetrunic.healthmon.database.generated.Keys.KEY_USER_PRIMARY, UserActivity.USER_ACTIVITY, UserActivity.USER_ACTIVITY.USER_ID);
		public static final ForeignKey<UserActivityRecord, ActivityRecord> FK_USER_ACTIVITY_ACTIVITY2 = createForeignKey(hr.fer.zpr.marinpetrunic.healthmon.database.generated.Keys.KEY_ACTIVITY_PRIMARY, UserActivity.USER_ACTIVITY, UserActivity.USER_ACTIVITY.ACTIVITY_ID);
		public static final ForeignKey<UserBloodPressureRecord, UserRecord> FK_USER_BLOOD_PRESSURE_USER1 = createForeignKey(hr.fer.zpr.marinpetrunic.healthmon.database.generated.Keys.KEY_USER_PRIMARY, UserBloodPressure.USER_BLOOD_PRESSURE, UserBloodPressure.USER_BLOOD_PRESSURE.USER_ID);
		public static final ForeignKey<UserHeartRateRecord, UserRecord> FK_USER_HEART_RATE_USER1 = createForeignKey(hr.fer.zpr.marinpetrunic.healthmon.database.generated.Keys.KEY_USER_PRIMARY, UserHeartRate.USER_HEART_RATE, UserHeartRate.USER_HEART_RATE.USER_ID);
		public static final ForeignKey<UserMealRecord, UserRecord> FK_USER_MEAL_USER1 = createForeignKey(hr.fer.zpr.marinpetrunic.healthmon.database.generated.Keys.KEY_USER_PRIMARY, UserMeal.USER_MEAL, UserMeal.USER_MEAL.USER_ID);
		public static final ForeignKey<UserMealRecord, MealTypeRecord> FK_USER_MEAL_MEAL_TYPE1 = createForeignKey(hr.fer.zpr.marinpetrunic.healthmon.database.generated.Keys.KEY_MEAL_TYPE_PRIMARY, UserMeal.USER_MEAL, UserMeal.USER_MEAL.MEAL_TYPE_ID);
		public static final ForeignKey<UserMealRecord, MealRecord> FK_USER_MEAL_MEAL1 = createForeignKey(hr.fer.zpr.marinpetrunic.healthmon.database.generated.Keys.KEY_MEAL_PRIMARY, UserMeal.USER_MEAL, UserMeal.USER_MEAL.MEAL_ID);
		public static final ForeignKey<UserTemperatureRecord, UserRecord> FK_USER_TEMPERATURE_USER1 = createForeignKey(hr.fer.zpr.marinpetrunic.healthmon.database.generated.Keys.KEY_USER_PRIMARY, UserTemperature.USER_TEMPERATURE, UserTemperature.USER_TEMPERATURE.USER_ID);
		public static final ForeignKey<UserWeightRecord, UserRecord> FK_USER_WEIGHT_USER1 = createForeignKey(hr.fer.zpr.marinpetrunic.healthmon.database.generated.Keys.KEY_USER_PRIMARY, UserWeight.USER_WEIGHT, UserWeight.USER_WEIGHT.USER_ID);
	}
}
