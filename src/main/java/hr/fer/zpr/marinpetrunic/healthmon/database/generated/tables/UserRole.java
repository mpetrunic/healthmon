/**
 * This class is generated by jOOQ
 */
package hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables;


import hr.fer.zpr.marinpetrunic.healthmon.database.generated.Healthmon;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.Keys;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.UserRoleRecord;

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
public class UserRole extends TableImpl<UserRoleRecord> {

	private static final long serialVersionUID = 1105707900;

	/**
	 * The reference instance of <code>healthmon.user_role</code>
	 */
	public static final UserRole USER_ROLE = new UserRole();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<UserRoleRecord> getRecordType() {
		return UserRoleRecord.class;
	}

	/**
	 * The column <code>healthmon.user_role.id</code>.
	 */
	public final TableField<UserRoleRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>healthmon.user_role.user_id</code>.
	 */
	public final TableField<UserRoleRecord, Integer> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>healthmon.user_role.role</code>.
	 */
	public final TableField<UserRoleRecord, String> ROLE = createField("role", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

	/**
	 * Create a <code>healthmon.user_role</code> table reference
	 */
	public UserRole() {
		this("user_role", null);
	}

	/**
	 * Create an aliased <code>healthmon.user_role</code> table reference
	 */
	public UserRole(String alias) {
		this(alias, USER_ROLE);
	}

	private UserRole(String alias, Table<UserRoleRecord> aliased) {
		this(alias, aliased, null);
	}

	private UserRole(String alias, Table<UserRoleRecord> aliased, Field<?>[] parameters) {
		super(alias, Healthmon.HEALTHMON, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<UserRoleRecord, Integer> getIdentity() {
		return Keys.IDENTITY_USER_ROLE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<UserRoleRecord> getPrimaryKey() {
		return Keys.KEY_USER_ROLE_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<UserRoleRecord>> getKeys() {
		return Arrays.<UniqueKey<UserRoleRecord>>asList(Keys.KEY_USER_ROLE_PRIMARY, Keys.KEY_USER_ROLE_UNI_USERNAME_ROLE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<UserRoleRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<UserRoleRecord, ?>>asList(Keys.FK_USERNAME);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRole as(String alias) {
		return new UserRole(alias, this);
	}

	/**
	 * Rename this table
	 */
	public UserRole rename(String name) {
		return new UserRole(name, null);
	}
}
