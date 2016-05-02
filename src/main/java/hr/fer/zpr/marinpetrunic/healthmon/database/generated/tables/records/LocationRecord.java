/**
 * This class is generated by jOOQ
 */
package hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records;


import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.Location;

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
public class LocationRecord extends UpdatableRecordImpl<LocationRecord> implements Record4<Integer, String, Double, Double> {

	private static final long serialVersionUID = -1526451017;

	/**
	 * Setter for <code>healthmon.location.id</code>.
	 */
	public LocationRecord setId(Integer value) {
		setValue(0, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.location.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>healthmon.location.city_name</code>.
	 */
	public LocationRecord setCityName(String value) {
		setValue(1, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.location.city_name</code>.
	 */
	public String getCityName() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>healthmon.location.lat</code>.
	 */
	public LocationRecord setLat(Double value) {
		setValue(2, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.location.lat</code>.
	 */
	public Double getLat() {
		return (Double) getValue(2);
	}

	/**
	 * Setter for <code>healthmon.location.long</code>.
	 */
	public LocationRecord setLong(Double value) {
		setValue(3, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.location.long</code>.
	 */
	public Double getLong() {
		return (Double) getValue(3);
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
	public Row4<Integer, String, Double, Double> fieldsRow() {
		return (Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, String, Double, Double> valuesRow() {
		return (Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Location.LOCATION.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Location.LOCATION.CITY_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Double> field3() {
		return Location.LOCATION.LAT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Double> field4() {
		return Location.LOCATION.LONG;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getCityName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double value3() {
		return getLat();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double value4() {
		return getLong();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationRecord value2(String value) {
		setCityName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationRecord value3(Double value) {
		setLat(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationRecord value4(Double value) {
		setLong(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationRecord values(Integer value1, String value2, Double value3, Double value4) {
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
	 * Create a detached LocationRecord
	 */
	public LocationRecord() {
		super(Location.LOCATION);
	}

	/**
	 * Create a detached, initialised LocationRecord
	 */
	public LocationRecord(Integer id, String cityName, Double lat, Double long_) {
		super(Location.LOCATION);

		setValue(0, id);
		setValue(1, cityName);
		setValue(2, lat);
		setValue(3, long_);
	}
}