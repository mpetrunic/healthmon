package hr.fer.zpr.marinpetrunic.healthmon.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * @author MarinPetrunic
 */
@Configuration
public class FlyWayConfig {

    @Bean
    @Profile({"staging", "prod"})
    @DependsOn(value = "dataSource")
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setBaselineOnMigrate(true);
        flyway.setLocations("classpath:db/migration");
        flyway.migrate();
        return flyway;
    }
}
