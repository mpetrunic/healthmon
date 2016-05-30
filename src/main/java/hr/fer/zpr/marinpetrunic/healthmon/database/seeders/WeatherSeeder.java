package hr.fer.zpr.marinpetrunic.healthmon.database.seeders;

import hr.fer.zpr.marinpetrunic.healthmon.services.OpenWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author MarinPetrunic
 */
@Profile("disabled")
@Component
@DependsOn("flyway")
public class WeatherSeeder implements CommandLineRunner {

    @Autowired
    private OpenWeatherService weatherService;

    @Override
    public void run(String... args) throws Exception {
        weatherService.obtainCityWeatherData();
    }
}
