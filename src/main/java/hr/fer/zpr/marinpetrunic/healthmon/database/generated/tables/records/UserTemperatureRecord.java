/**
 * This class is generated by jOOQ
 */
package hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records;


import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserTemperature;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


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
public class UserTemperatureRecord extends UpdatableRecordImpl<UserTemperatureRecord> implements Record4<Integer, Double, Timestamp, Integer> {

	private static final long serialVersionUID = 814232521;

	/**
	 * Setter for <code>healthmon.user_temperature.user_temperature_id</code>.
	 */
	public UserTemperatureRecord setUserTemperatureId(Integer value) {
		setValue(0, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.user_temperature.user_temperature_id</code>.
	 */
	public Integer getUserTemperatureId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>healthmon.user_temperature.temperature</code>.
	 */
	public UserTemperatureRecord setTemperature(Double value) {
		setValue(1, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.user_temperature.temperature</code>.
	 */
	public Double getTemperature() {
		return (Double) getValue(1);
	}

	/**
	 * Setter for <code>healthmon.user_temperature.insert_date</code>.
	 */
	public UserTemperatureRecord setInsertDate(Timestamp value) {
		setValue(2, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.user_temperature.insert_date</code>.
	 */
	public Timestamp getInsertDate() {
		return (Timestamp) getValue(2);
	}

	/**
	 * Setter for <code>healthmon.user_temperature.user_id</code>.
	 */
	public UserTemperatureRecord setUserId(Integer value) {
		setValue(3, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.user_temperature.user_id</code>.
	 */
	public Integer getUserId() {
		return (Integer) getValue(3);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, Double, Timestamp, Integer> fieldsRow() {
		return (Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, Double, Timestamp, Integer> valuesRow() {
		return (Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return UserTemperature.USER_TEMPERATURE.USER_TEMPERATURE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Double> field2() {
		return UserTemperature.USER_TEMPERATURE.TEMPERATURE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field3() {
		return UserTemperature.USER_TEMPERATURE.INSERT_DATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field4() {
		return UserTemperature.USER_TEMPERATURE.USER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getUserTemperatureId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double value2() {
		return getTemperature();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value3() {
		return getInsertDate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value4() {
		return getUserId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserTemperatureRecord value1(Integer value) {
		setUserTemperatureId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserTemperatureRecord value2(Double value) {
		setTemperature(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserTemperatureRecord value3(Timestamp value) {
		setInsertDate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserTemperatureRecord value4(Integer value) {
		setUserId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserTemperatureRecord values(Integer value1, Double value2, Timestamp value3, Integer value4) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached UserTemperatureRecord
	 */
	public UserTemperatureRecord() {
		super(UserTemperature.USER_TEMPERATURE);
	}

	/**
	 * Create a detached, initialised UserTemperatureRecord
	 */
	public UserTemperatureRecord(Integer userTemperatureId, Double temperature, Timestamp insertDate, Integer userId) {
		super(UserTemperature.USER_TEMPERATURE);

		setValue(0, userTemperatureId);
		setValue(1, temperature);
		setValue(2, insertDate);
		setValue(3, userId);
	}
}
