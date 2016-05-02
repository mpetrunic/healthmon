/**
 * This class is generated by jOOQ
 */
package hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables;


import hr.fer.zpr.marinpetrunic.healthmon.database.generated.Healthmon;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.Keys;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.ActivityRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
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
public class Activity extends TableImpl<ActivityRecord> {

	private static final long serialVersionUID = 864057979;

	/**
	 * The reference instance of <code>healthmon.activity</code>
	 */
	public static final Activity ACTIVITY = new Activity();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<ActivityRecord> getRecordType() {
		return ActivityRecord.class;
	}

	/**
	 * The column <code>healthmon.activity.id</code>.
	 */
	public final TableField<ActivityRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>healthmon.activity.name</code>.
	 */
	public final TableField<ActivityRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

	/**
	 * The column <code>healthmon.activity.average_calories_per_min</code>.
	 */
	public final TableField<ActivityRecord, Double> AVERAGE_CALORIES_PER_MIN = createField("average_calories_per_min", org.jooq.impl.SQLDataType.FLOAT.nullable(false), this, "");

	/**
	 * Create a <code>healthmon.activity</code> table reference
	 */
	public Activity() {
		this("activity", null);
	}

	/**
	 * Create an aliased <code>healthmon.activity</code> table reference
	 */
	public Activity(String alias) {
		this(alias, ACTIVITY);
	}

	private Activity(String alias, Table<ActivityRecord> aliased) {
		this(alias, aliased, null);
	}

	private Activity(String alias, Table<ActivityRecord> aliased, Field<?>[] parameters) {
		super(alias, Healthmon.HEALTHMON, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<ActivityRecord, Integer> getIdentity() {
		return Keys.IDENTITY_ACTIVITY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<ActivityRecord> getPrimaryKey() {
		return Keys.KEY_ACTIVITY_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<ActivityRecord>> getKeys() {
		return Arrays.<UniqueKey<ActivityRecord>>asList(Keys.KEY_ACTIVITY_PRIMARY, Keys.KEY_ACTIVITY_ID_UNIQUE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Activity as(String alias) {
		return new Activity(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Activity rename(String name) {
		return new Activity(name, null);
	}
}
