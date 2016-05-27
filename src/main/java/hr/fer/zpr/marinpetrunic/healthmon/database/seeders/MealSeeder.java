package hr.fer.zpr.marinpetrunic.healthmon.database.seeders;

import hr.fer.zpr.marinpetrunic.healthmon.models.MealModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IMealRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MarinPetrunic
 */
@Component
public class MealSeeder implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(MealSeeder.class);

    private static final String ENERGY_ID = "~208~";

    private static final String FAT_ID = "~204~";

    private static final String PROTEINS_ID = "~203~";

    @Autowired
    private IMealRepository mealRepository;

    private Map<Integer, MealModel> meals = new HashMap<>();

    @Override
    public void run(String... args) throws Exception {
        if(mealRepository.size() > 0) return;
        LOGGER.info("Seeding meals!");
        List<String> foodLines = Files.readAllLines(
                Paths.get(this.getClass().getClassLoader().getResource("db/seed/meals/FOOD_DES.txt").toURI()),
                StandardCharsets.ISO_8859_1);
        List<String> nutrientLines = Files.readAllLines(
                Paths.get(this.getClass().getClassLoader().getResource("db/seed/meals/NUT_DATA_filtered.txt").toURI()),
                StandardCharsets.ISO_8859_1);
        for(String foodLine : foodLines) {
            String[] foodParts = foodLine.split("\\^");
            MealModel model = new MealModel();
            model.setName(foodParts[2].substring(1, foodParts[2].length()-1));
            meals.put(Integer.parseInt(foodParts[0].substring(1, foodParts[0].length()-1)), model);
        }
        for(String nutrient : nutrientLines) {
            String[] nutrientParts = nutrient.split("\\^");
            Integer id = Integer.parseInt(nutrientParts[0].substring(1, nutrientParts[0].length()-1));
            MealModel model = meals.get(id);
            if(model == null) continue;
            if(nutrientParts[1].equals(ENERGY_ID)){
                try {
                    model.setCalories(Integer.parseInt(nutrientParts[2]));
                } catch (Exception e) {
                    meals.remove(id);
                    continue;
                }
            }
            if(nutrientParts[1].equals(FAT_ID)){
                try {
                    model.setFat(Float.parseFloat(nutrientParts[2]));
                } catch (Exception e) {
                    meals.remove(id);
                    continue;
                }
            }
            if(nutrientParts[1].equals(PROTEINS_ID)){
                try {
                    model.setProteins(Float.parseFloat(nutrientParts[2]));
                } catch (Exception e) {
                    meals.remove(id);
                    continue;
                }
            }
            meals.put(id, model);
        }
        for(Map.Entry<Integer, MealModel> entry : meals.entrySet()) {
            mealRepository.store(entry.getValue());
        }
    }
}
