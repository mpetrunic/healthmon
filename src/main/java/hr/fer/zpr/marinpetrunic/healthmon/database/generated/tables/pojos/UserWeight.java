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
public class UserWeight implements Serializable {

	private static final long serialVersionUID = -1413313394;

	private final Integer   userWeightId;
	private final Integer   weight;
	private final Timestamp insertDate;
	private final Integer   userId;

	public UserWeight(UserWeight value) {
		this.userWeightId = value.userWeightId;
		this.weight = value.weight;
		this.insertDate = value.insertDate;
		this.userId = value.userId;
	}

	public UserWeight(
		Integer   userWeightId,
		Integer   weight,
		Timestamp insertDate,
		Integer   userId
	) {
		this.userWeightId = userWeightId;
		this.weight = weight;
		this.insertDate = insertDate;
		this.userId = userId;
	}

	public Integer getUserWeightId() {
		return this.userWeightId;
	}

	public Integer getWeight() {
		return this.weight;
	}

	public Timestamp getInsertDate() {
		return this.insertDate;
	}

	public Integer getUserId() {
		return this.userId;
	}
}