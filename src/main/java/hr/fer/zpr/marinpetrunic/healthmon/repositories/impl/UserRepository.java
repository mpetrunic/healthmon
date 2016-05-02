package hr.fer.zpr.marinpetrunic.healthmon.repositories.impl;

import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.User;
import hr.fer.zpr.marinpetrunic.healthmon.models.UserModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IUserRepository;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

/**
 * @author MarinPetrunic
 */
@Repository
public class UserRepository implements IUserRepository, UserDetailsService {

    private static final User USERS = new User();

    @Autowired
    private DSLContext dsl;

    @Override
    public UserModel getById(Integer id) {
        return dsl.selectFrom(USERS).where(USERS.ID.equal(id)).fetchAny().into(UserModel.class);
    }

    @Override
    public UserModel getByUsername(String username) {
        return dsl.selectFrom(USERS).where(USERS.USERNAME.equal(username)).fetchAny().into(UserModel.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getByUsername(username);
    }
}
