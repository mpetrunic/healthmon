package hr.fer.zpr.marinpetrunic.healthmon.repositories;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author MarinPetrunic
 */
public class BaseRepository {

    @Autowired
    protected DSLContext dsl;
}
