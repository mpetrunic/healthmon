/**
 * This class is generated by jOOQ
 */
package hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables;


import hr.fer.zpr.marinpetrunic.healthmon.database.generated.Healthmon;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.Keys;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.UserActivityRecord;

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
public class UserActivity extends TableImpl<UserActivityRecord> {

	private static final long serialVersionUID = 816397082;

	/**
	 * The reference instance of <code>healthmon.user_activity</code>
	 */
	public static final UserActivity USER_ACTIVITY = new UserActivity();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<UserActivityRecord> getRecordType() {
		return UserActivityRecord.class;
	}

	/**
	 * The column <code>healthmon.user_activity.user_activity_id</code>.
	 */
	public final TableField<UserActivityRecord, Integer> USER_ACTIVITY_ID = createField("user_activity_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>healthmon.user_activity.calories_burned</code>.
	 */
	public final TableField<UserActivityRecord, Integer> CALORIES_BURNED = createField("calories_burned", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>healthmon.user_activity.activity_lenght</code>.
	 */
	public final TableField<UserActivityRecord, Double> ACTIVITY_LENGHT = createField("activity_lenght", org.jooq.impl.SQLDataType.DOUBLE.nullable(false), this, "");

	/**
	 * The column <code>healthmon.user_activity.insert_date</code>.
	 */
	public final TableField<UserActivityRecord, Timestamp> INSERT_DATE = createField("insert_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>healthmon.user_activity.user_id</code>.
	 */
	public final TableField<UserActivityRecord, Integer> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>healthmon.user_activity.activity_id</code>.
	 */
	public final TableField<UserActivityRecord, Integer> ACTIVITY_ID = createField("activity_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * Create a <code>healthmon.user_activity</code> table reference
	 */
	public UserActivity() {
		this("user_activity", null);
	}

	/**
	 * Create an aliased <code>healthmon.user_activity</code> table reference
	 */
	public UserActivity(String alias) {
		this(alias, USER_ACTIVITY);
	}

	private UserActivity(String alias, Table<UserActivityRecord> aliased) {
		this(alias, aliased, null);
	}

	private UserActivity(String alias, Table<UserActivityRecord> aliased, Field<?>[] parameters) {
		super(alias, Healthmon.HEALTHMON, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<UserActivityRecord, Integer> getIdentity() {
		return Keys.IDENTITY_USER_ACTIVITY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<UserActivityRecord> getPrimaryKey() {
		return Keys.KEY_USER_ACTIVITY_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<UserActivityRecord>> getKeys() {
		return Arrays.<UniqueKey<UserActivityRecord>>asList(Keys.KEY_USER_ACTIVITY_PRIMARY, Keys.KEY_USER_ACTIVITY_ID_UNIQUE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<UserActivityRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<UserActivityRecord, ?>>asList(Keys.FK_USER_ACTIVITY_USER1, Keys.FK_USER_ACTIVITY_ACTIVITY2);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserActivity as(String alias) {
		return new UserActivity(alias, this);
	}

	/**
	 * Rename this table
	 */
	public UserActivity rename(String name) {
		return new UserActivity(name, null);
	}
}
