/**
 * This class is generated by jOOQ
 */
package hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables;


import hr.fer.zpr.marinpetrunic.healthmon.database.generated.Healthmon;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.Keys;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.UserBloodPressureRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class UserBloodPressure extends TableImpl<UserBloodPressureRecord> {

	private static final long serialVersionUID = 191854977;

	/**
	 * The reference instance of <code>healthmon.user_blood_pressure</code>
	 */
	public static final UserBloodPressure USER_BLOOD_PRESSURE = new UserBloodPressure();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<UserBloodPressureRecord> getRecordType() {
		return UserBloodPressureRecord.class;
	}

	/**
	 * The column <code>healthmon.user_blood_pressure.user_blood_pressure_id</code>.
	 */
	public final TableField<UserBloodPressureRecord, Integer> USER_BLOOD_PRESSURE_ID = createField("user_blood_pressure_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>healthmon.user_blood_pressure.diastolic</code>.
	 */
	public final TableField<UserBloodPressureRecord, Integer> DIASTOLIC = createField("diastolic", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>healthmon.user_blood_pressure.systolic</code>.
	 */
	public final TableField<UserBloodPressureRecord, Integer> SYSTOLIC = createField("systolic", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>healthmon.user_blood_pressure.insert_date</code>.
	 */
	public final TableField<UserBloodPressureRecord, Timestamp> INSERT_DATE = createField("insert_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>healthmon.user_blood_pressure.user_id</code>.
	 */
	public final TableField<UserBloodPressureRecord, Integer> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * Create a <code>healthmon.user_blood_pressure</code> table reference
	 */
	public UserBloodPressure() {
		this("user_blood_pressure", null);
	}

	/**
	 * Create an aliased <code>healthmon.user_blood_pressure</code> table reference
	 */
	public UserBloodPressure(String alias) {
		this(alias, USER_BLOOD_PRESSURE);
	}

	private UserBloodPressure(String alias, Table<UserBloodPressureRecord> aliased) {
		this(alias, aliased, null);
	}

	private UserBloodPressure(String alias, Table<UserBloodPressureRecord> aliased, Field<?>[] parameters) {
		super(alias, Healthmon.HEALTHMON, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<UserBloodPressureRecord, Integer> getIdentity() {
		return Keys.IDENTITY_USER_BLOOD_PRESSURE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<UserBloodPressureRecord> getPrimaryKey() {
		return Keys.KEY_USER_BLOOD_PRESSURE_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<UserBloodPressureRecord>> getKeys() {
		return Arrays.<UniqueKey<UserBloodPressureRecord>>asList(Keys.KEY_USER_BLOOD_PRESSURE_PRIMARY, Keys.KEY_USER_BLOOD_PRESSURE_USER_HEART_PRESSURE_ID_UNIQUE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<UserBloodPressureRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<UserBloodPressureRecord, ?>>asList(Keys.FK_USER_BLOOD_PRESSURE_USER1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserBloodPressure as(String alias) {
		return new UserBloodPressure(alias, this);
	}

	/**
	 * Rename this table
	 */
	public UserBloodPressure rename(String name) {
		return new UserBloodPressure(name, null);
	}
}
