/**
 * This class is generated by jOOQ
 */
package hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records;


import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.EnvironmentStatistic;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
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
public class EnvironmentStatisticRecord extends UpdatableRecordImpl<EnvironmentStatisticRecord> implements Record6<Integer, Double, Double, Integer, Timestamp, Integer> {

	private static final long serialVersionUID = -120614706;

	/**
	 * Setter for <code>healthmon.environment_statistic.environment_statistic_id</code>.
	 */
	public EnvironmentStatisticRecord setEnvironmentStatisticId(Integer value) {
		setValue(0, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.environment_statistic.environment_statistic_id</code>.
	 */
	public Integer getEnvironmentStatisticId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>healthmon.environment_statistic.temperature</code>.
	 */
	public EnvironmentStatisticRecord setTemperature(Double value) {
		setValue(1, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.environment_statistic.temperature</code>.
	 */
	public Double getTemperature() {
		return (Double) getValue(1);
	}

	/**
	 * Setter for <code>healthmon.environment_statistic.humidity</code>.
	 */
	public EnvironmentStatisticRecord setHumidity(Double value) {
		setValue(2, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.environment_statistic.humidity</code>.
	 */
	public Double getHumidity() {
		return (Double) getValue(2);
	}

	/**
	 * Setter for <code>healthmon.environment_statistic.air_pressure</code>.
	 */
	public EnvironmentStatisticRecord setAirPressure(Integer value) {
		setValue(3, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.environment_statistic.air_pressure</code>.
	 */
	public Integer getAirPressure() {
		return (Integer) getValue(3);
	}

	/**
	 * Setter for <code>healthmon.environment_statistic.insert_date</code>.
	 */
	public EnvironmentStatisticRecord setInsertDate(Timestamp value) {
		setValue(4, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.environment_statistic.insert_date</code>.
	 */
	public Timestamp getInsertDate() {
		return (Timestamp) getValue(4);
	}

	/**
	 * Setter for <code>healthmon.environment_statistic.location_id</code>.
	 */
	public EnvironmentStatisticRecord setLocationId(Integer value) {
		setValue(5, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.environment_statistic.location_id</code>.
	 */
	public Integer getLocationId() {
		return (Integer) getValue(5);
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
	// Record6 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row6<Integer, Double, Double, Integer, Timestamp, Integer> fieldsRow() {
		return (Row6) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row6<Integer, Double, Double, Integer, Timestamp, Integer> valuesRow() {
		return (Row6) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return EnvironmentStatistic.ENVIRONMENT_STATISTIC.ENVIRONMENT_STATISTIC_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Double> field2() {
		return EnvironmentStatistic.ENVIRONMENT_STATISTIC.TEMPERATURE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Double> field3() {
		return EnvironmentStatistic.ENVIRONMENT_STATISTIC.HUMIDITY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field4() {
		return EnvironmentStatistic.ENVIRONMENT_STATISTIC.AIR_PRESSURE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field5() {
		return EnvironmentStatistic.ENVIRONMENT_STATISTIC.INSERT_DATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field6() {
		return EnvironmentStatistic.ENVIRONMENT_STATISTIC.LOCATION_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getEnvironmentStatisticId();
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
	public Double value3() {
		return getHumidity();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value4() {
		return getAirPressure();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value5() {
		return getInsertDate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value6() {
		return getLocationId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EnvironmentStatisticRecord value1(Integer value) {
		setEnvironmentStatisticId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EnvironmentStatisticRecord value2(Double value) {
		setTemperature(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EnvironmentStatisticRecord value3(Double value) {
		setHumidity(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EnvironmentStatisticRecord value4(Integer value) {
		setAirPressure(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EnvironmentStatisticRecord value5(Timestamp value) {
		setInsertDate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EnvironmentStatisticRecord value6(Integer value) {
		setLocationId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EnvironmentStatisticRecord values(Integer value1, Double value2, Double value3, Integer value4, Timestamp value5, Integer value6) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached EnvironmentStatisticRecord
	 */
	public EnvironmentStatisticRecord() {
		super(EnvironmentStatistic.ENVIRONMENT_STATISTIC);
	}

	/**
	 * Create a detached, initialised EnvironmentStatisticRecord
	 */
	public EnvironmentStatisticRecord(Integer environmentStatisticId, Double temperature, Double humidity, Integer airPressure, Timestamp insertDate, Integer locationId) {
		super(EnvironmentStatistic.ENVIRONMENT_STATISTIC);

		setValue(0, environmentStatisticId);
		setValue(1, temperature);
		setValue(2, humidity);
		setValue(3, airPressure);
		setValue(4, insertDate);
		setValue(5, locationId);
	}
}
