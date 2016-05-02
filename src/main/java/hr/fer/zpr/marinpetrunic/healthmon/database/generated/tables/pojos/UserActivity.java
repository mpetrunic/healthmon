/**
 * This class is generated by jOOQ
 */
package hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


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
public class UserActivity implements Serializable {

	private static final long serialVersionUID = -1338252387;

	private final Integer   userActivityId;
	private final Integer   caloriesBurned;
	private final Double    activityLenght;
	private final Timestamp insertDate;
	private final Integer   userId;
	private final Integer   activityId;

	public UserActivity(UserActivity value) {
		this.userActivityId = value.userActivityId;
		this.caloriesBurned = value.caloriesBurned;
		this.activityLenght = value.activityLenght;
		this.insertDate = value.insertDate;
		this.userId = value.userId;
		this.activityId = value.activityId;
	}

	public UserActivity(
		Integer   userActivityId,
		Integer   caloriesBurned,
		Double    activityLenght,
		Timestamp insertDate,
		Integer   userId,
		Integer   activityId
	) {
		this.userActivityId = userActivityId;
		this.caloriesBurned = caloriesBurned;
		this.activityLenght = activityLenght;
		this.insertDate = insertDate;
		this.userId = userId;
		this.activityId = activityId;
	}

	public Integer getUserActivityId() {
		return this.userActivityId;
	}

	public Integer getCaloriesBurned() {
		return this.caloriesBurned;
	}

	public Double getActivityLenght() {
		return this.activityLenght;
	}

	public Timestamp getInsertDate() {
		return this.insertDate;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public Integer getActivityId() {
		return this.activityId;
	}
}
