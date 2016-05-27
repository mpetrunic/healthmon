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
public class UserMeal implements Serializable {

	private static final long serialVersionUID = -818181951;

	private final Integer   userMealId;
	private final Integer   userId;
	private final Integer   mealTypeId;
	private final Timestamp insertDate;
	private final Integer   mealId;

	public UserMeal(UserMeal value) {
		this.userMealId = value.userMealId;
		this.userId = value.userId;
		this.mealTypeId = value.mealTypeId;
		this.insertDate = value.insertDate;
		this.mealId = value.mealId;
	}

	public UserMeal(
		Integer   userMealId,
		Integer   userId,
		Integer   mealTypeId,
		Timestamp insertDate,
		Integer   mealId
	) {
		this.userMealId = userMealId;
		this.userId = userId;
		this.mealTypeId = mealTypeId;
		this.insertDate = insertDate;
		this.mealId = mealId;
	}

	public Integer getUserMealId() {
		return this.userMealId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public Integer getMealTypeId() {
		return this.mealTypeId;
	}

	public Timestamp getInsertDate() {
		return this.insertDate;
	}

	public Integer getMealId() {
		return this.mealId;
	}
}
