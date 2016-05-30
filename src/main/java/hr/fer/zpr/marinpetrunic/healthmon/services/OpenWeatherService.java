package hr.fer.zpr.marinpetrunic.healthmon.services;

import hr.fer.zpr.marinpetrunic.healthmon.models.EnvioronmentStatisticModel;
import hr.fer.zpr.marinpetrunic.healthmon.models.LocationModel;
import hr.fer.zpr.marinpetrunic.healthmon.models.weather.OpenWeatherResponse;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IEnvioronmentStatisticRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.ILocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

/**
 * @author MarinPetrunic
 */
@Service
public class OpenWeatherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenWeatherService.class);

    private static final String QUERY_LAT_LONG_WEATHER = "http://api.openweathermap.org/data/2.5/weather?lat={0}&lon={1}&APPID={2}&units=metric";

    @Autowired
    private ILocationRepository locationRepository;

    @Autowired
    private IEnvioronmentStatisticRepository envioronmentStatisticRepository;

    @Value("${openweather.key}")
    private String apiKey;

    public OpenWeatherResponse query(Double lat, Double log) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(MessageFormat.format(QUERY_LAT_LONG_WEATHER,lat, log, apiKey), OpenWeatherResponse.class);
    }

    @Scheduled(cron = "0 0 * * * *")
    public void obtainCityWeatherData() {
        if(this.apiKey == null || this.apiKey.isEmpty()) {
            this.apiKey = System.getProperty("openweather.key");
            return;
        }
        if(this.apiKey == null || this.apiKey.isEmpty()) {
            LOGGER.warn("OpenWeather api key not set!");
            return;
        }
        for(LocationModel loc : locationRepository.all()) {
            OpenWeatherResponse resp = this.query(loc.getLat(), loc.getLon());
            EnvioronmentStatisticModel model = resp.toEnvioronmentStatisticModel();
            model.setLocationId(loc.getId());
            LOGGER.info("Saving Envioronment data for {}", loc.getCityName());
            envioronmentStatisticRepository.store(model);
        }
    }
}
