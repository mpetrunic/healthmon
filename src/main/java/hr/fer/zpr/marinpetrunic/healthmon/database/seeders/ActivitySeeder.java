package hr.fer.zpr.marinpetrunic.healthmon.database.seeders;

import hr.fer.zpr.marinpetrunic.healthmon.models.ActivityModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IActivityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @author MarinPetrunic
 */
@Component
@DependsOn("flyway")
public class ActivitySeeder implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivitySeeder.class);

    @Autowired
    private IActivityRepository activityRepository;

    @Override
    public void run(String... args) throws Exception {
        if(activityRepository.all().size() > 0) return;
        LOGGER.info("Seeding activities!");
        activityRepository.store(new ActivityModel("Aerobics: water", 112F/30));
        activityRepository.store(new ActivityModel("Bicycling", 298F/30));
        activityRepository.store(new ActivityModel("Rowing", 260F/30));
        activityRepository.store(new ActivityModel("Dancing", 112F/30));
        activityRepository.store(new ActivityModel("Badminton", 167F/30));
        activityRepository.store(new ActivityModel("Walking", 149F/30));
        activityRepository.store(new ActivityModel("Running: 5 mph", 298F/30));
        activityRepository.store(new ActivityModel("Bicycling: BMX or mountain", 316F/30));
        activityRepository.store(new ActivityModel("Swimming: breaststroke", 372F/30));
    }
}
