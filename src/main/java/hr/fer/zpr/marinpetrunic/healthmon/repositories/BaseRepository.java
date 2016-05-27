package hr.fer.zpr.marinpetrunic.healthmon.repositories;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author MarinPetrunic
 */
@Repository
public abstract class BaseRepository {

    @Autowired
    protected DSLContext dsl;
}
