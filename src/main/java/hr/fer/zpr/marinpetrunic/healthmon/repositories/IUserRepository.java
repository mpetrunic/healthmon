package hr.fer.zpr.marinpetrunic.healthmon.repositories;

import hr.fer.zpr.marinpetrunic.healthmon.models.UserModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author MarinPetrunic
 */
public interface IUserRepository extends UserDetailsService {

    public UserModel getById(Integer id);

    public UserModel getByUsername(String username);

    public UserModel storeUser(UserModel user);

}
