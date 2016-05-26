package hr.fer.zpr.marinpetrunic.healthmon.repositories.impl;

import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.Location;
import hr.fer.zpr.marinpetrunic.healthmon.database.generated.tables.records.LocationRecord;
import hr.fer.zpr.marinpetrunic.healthmon.models.LocationModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.BaseRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.ILocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MarinPetrunic
 */
@Repository
public class LocationRepository extends BaseRepository implements ILocationRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationRepository.class);

    private static final Location LOCATION = new Location();

    @Override
    public LocationModel get(Integer id) {
        LocationRecord record = dsl.selectFrom(LOCATION).where(LOCATION.ID.equal(id)).fetchAny();
        if(record != null) {
            return record.into(LocationModel.class);
        }
        return null;
    }

    @Override
    public LocationModel get(String name) {
        LocationRecord record = dsl.selectFrom(LOCATION).where(LOCATION.CITY_NAME.equal(name)).fetchAny();
        if(record != null) {
            return record.into(LocationModel.class);
        }
        return null;
    }

    @Override
    public List<LocationModel> all() {
        return dsl.selectFrom(LOCATION).fetch().into(LocationModel.class);
    }

    @Override
    public LocationModel store(LocationModel location) {
        LocationModel existingLocation = this.get(location.getCityName());
        if(existingLocation != null) {
            return existingLocation;
        }
        LocationRecord record = new LocationRecord();
        record.from(location);
        dsl.attach(record);
        record.store();
        location.setId(record.getId());
        return location;
    }
}
