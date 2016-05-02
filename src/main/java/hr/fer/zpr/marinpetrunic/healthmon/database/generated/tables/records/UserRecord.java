/**
 * This class is generated by jOOQ
 */
package hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records;


import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.User;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
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
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record8<Integer, String, String, String, String, Timestamp, String, Integer> {

	private static final long serialVersionUID = -786279683;

	/**
	 * Setter for <code>healthmon.user.id</code>.
	 */
	public UserRecord setId(Integer value) {
		setValue(0, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.user.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>healthmon.user.username</code>.
	 */
	public UserRecord setUsername(String value) {
		setValue(1, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.user.username</code>.
	 */
	public String getUsername() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>healthmon.user.name</code>.
	 */
	public UserRecord setName(String value) {
		setValue(2, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.user.name</code>.
	 */
	public String getName() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>healthmon.user.surname</code>.
	 */
	public UserRecord setSurname(String value) {
		setValue(3, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.user.surname</code>.
	 */
	public String getSurname() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>healthmon.user.password</code>.
	 */
	public UserRecord setPassword(String value) {
		setValue(4, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.user.password</code>.
	 */
	public String getPassword() {
		return (String) getValue(4);
	}

	/**
	 * Setter for <code>healthmon.user.insert_date</code>.
	 */
	public UserRecord setInsertDate(Timestamp value) {
		setValue(5, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.user.insert_date</code>.
	 */
	public Timestamp getInsertDate() {
		return (Timestamp) getValue(5);
	}

	/**
	 * Setter for <code>healthmon.user.email</code>.
	 */
	public UserRecord setEmail(String value) {
		setValue(6, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.user.email</code>.
	 */
	public String getEmail() {
		return (String) getValue(6);
	}

	/**
	 * Setter for <code>healthmon.user.location_id</code>.
	 */
	public UserRecord setLocationId(Integer value) {
		setValue(7, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.user.location_id</code>.
	 */
	public Integer getLocationId() {
		return (Integer) getValue(7);
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
	// Record8 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row8<Integer, String, String, String, String, Timestamp, String, Integer> fieldsRow() {
		return (Row8) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row8<Integer, String, String, String, String, Timestamp, String, Integer> valuesRow() {
		return (Row8) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return User.USER.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return User.USER.USERNAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return User.USER.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return User.USER.SURNAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field5() {
		return User.USER.PASSWORD;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field6() {
		return User.USER.INSERT_DATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field7() {
		return User.USER.EMAIL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field8() {
		return User.USER.LOCATION_ID;
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
		return getUsername();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getSurname();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value5() {
		return getPassword();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value6() {
		return getInsertDate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value7() {
		return getEmail();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value8() {
		return getLocationId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value2(String value) {
		setUsername(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value3(String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value4(String value) {
		setSurname(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value5(String value) {
		setPassword(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value6(Timestamp value) {
		setInsertDate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value7(String value) {
		setEmail(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value8(Integer value) {
		setLocationId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord values(Integer value1, String value2, String value3, String value4, String value5, Timestamp value6, String value7, Integer value8) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached UserRecord
	 */
	public UserRecord() {
		super(User.USER);
	}

	/**
	 * Create a detached, initialised UserRecord
	 */
	public UserRecord(Integer id, String username, String name, String surname, String password, Timestamp insertDate, String email, Integer locationId) {
		super(User.USER);

		setValue(0, id);
		setValue(1, username);
		setValue(2, name);
		setValue(3, surname);
		setValue(4, password);
		setValue(5, insertDate);
		setValue(6, email);
		setValue(7, locationId);
	}
}