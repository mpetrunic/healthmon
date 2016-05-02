package hr.fer.zpr.marinpetrunic.healthmon.repositories;

import hr.fer.zpr.marinpetrunic.healthmon.models.UserModel;

/**
 * @author MarinPetrunic
 */
public interface IUserRepository {

    public UserModel getById(Integer id);

    public UserModel getByUsername(String username);
}
