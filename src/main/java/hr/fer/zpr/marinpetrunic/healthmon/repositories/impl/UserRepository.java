package hr.fer.zpr.marinpetrunic.healthmon.repositories.impl;

import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.User;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.LocationRecord;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.UserRecord;
import hr.fer.zpr.marinpetrunic.healthmon.models.LocationModel;
import hr.fer.zpr.marinpetrunic.healthmon.models.UserModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.BaseRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.ILocationRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author MarinPetrunic
 */
@Repository
public class UserRepository extends BaseRepository implements IUserRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);

    private static final User USERS = new User();

    @Autowired
    private ILocationRepository locationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserModel getById(Integer id) {
        UserRecord record = dsl.selectFrom(USERS).where(USERS.ID.equal(id)).fetchAny();
        if(record != null) {
            return record.into(UserModel.class);
        }
        return null;
    }

    @Override
    public UserModel getByUsername(String username) {
        UserRecord record = dsl.selectFrom(USERS).where(USERS.USERNAME.equal(username)).fetchAny();
        if(record != null) {
            return record.into(UserModel.class);
        }
        return null;
    }

    @Override
    @Transactional
    public UserModel storeUser(UserModel user) {
        LocationModel location = locationRepository.store(user.getLocation());
        user.getLocation().setId(location.getId());
        user.setLocationId(location.getId());
        user.setInsertDate(LocalDateTime.now());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserRecord record = new UserRecord();
        record.from(user);
        dsl.attach(record);
        if(record.store() == 1) {
            user.setId(record.getId());
            return user;
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getByUsername(username);
    }
}
