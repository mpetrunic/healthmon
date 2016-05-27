package hr.fer.zpr.marinpetrunic.healthmon.database.seeders;

import hr.fer.zpr.marinpetrunic.healthmon.models.MealTypeModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IMealTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author MarinPetrunic
 */
@Component
public class MealTypeSeeder implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(MealTypeSeeder.class);

    @Autowired
    private IMealTypeRepository mealTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        if(mealTypeRepository.all().size() > 0) return;
        LOGGER.info("Seeding meal types!");
        mealTypeRepository.store(new MealTypeModel("Breakfast"));
        mealTypeRepository.store(new MealTypeModel("Lunch"));
        mealTypeRepository.store(new MealTypeModel("Snack"));
        mealTypeRepository.store(new MealTypeModel("Dinner"));
    }
}
