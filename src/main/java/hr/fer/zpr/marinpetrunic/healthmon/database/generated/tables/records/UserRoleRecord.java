/**
 * This class is generated by jOOQ
 */
package hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records;


import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.UserRole;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class UserRoleRecord extends UpdatableRecordImpl<UserRoleRecord> implements Record3<Integer, Integer, String> {

	private static final long serialVersionUID = -1001504395;

	/**
	 * Setter for <code>healthmon.user_role.id</code>.
	 */
	public UserRoleRecord setId(Integer value) {
		setValue(0, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.user_role.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>healthmon.user_role.user_id</code>.
	 */
	public UserRoleRecord setUserId(Integer value) {
		setValue(1, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.user_role.user_id</code>.
	 */
	public Integer getUserId() {
		return (Integer) getValue(1);
	}

	/**
	 * Setter for <code>healthmon.user_role.role</code>.
	 */
	public UserRoleRecord setRole(String value) {
		setValue(2, value);
		return this;
	}

	/**
	 * Getter for <code>healthmon.user_role.role</code>.
	 */
	public String getRole() {
		return (String) getValue(2);
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
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row3<Integer, Integer, String> fieldsRow() {
		return (Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row3<Integer, Integer, String> valuesRow() {
		return (Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return UserRole.USER_ROLE.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return UserRole.USER_ROLE.USER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return UserRole.USER_ROLE.ROLE;
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
	public Integer value2() {
		return getUserId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getRole();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRoleRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRoleRecord value2(Integer value) {
		setUserId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRoleRecord value3(String value) {
		setRole(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRoleRecord values(Integer value1, Integer value2, String value3) {
		value1(value1);
		value2(value2);
		value3(value3);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached UserRoleRecord
	 */
	public UserRoleRecord() {
		super(UserRole.USER_ROLE);
	}

	/**
	 * Create a detached, initialised UserRoleRecord
	 */
	public UserRoleRecord(Integer id, Integer userId, String role) {
		super(UserRole.USER_ROLE);

		setValue(0, id);
		setValue(1, userId);
		setValue(2, role);
	}
}
