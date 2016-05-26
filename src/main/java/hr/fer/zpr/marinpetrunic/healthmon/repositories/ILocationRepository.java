package hr.fer.zpr.marinpetrunic.healthmon.repositories;

import hr.fer.zpr.marinpetrunic.healthmon.models.LocationModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author MarinPetrunic
 */
public interface ILocationRepository {

    public LocationModel get(Integer id);

    public LocationModel get(String name);

    public List<LocationModel> all();

    @Transactional
    public LocationModel store(LocationModel location);

}
