package hr.fer.zpr.marinpetrunic.healthmon.services;

import hr.fer.zpr.marinpetrunic.healthmon.models.EnvioronmentStatisticModel;
import hr.fer.zpr.marinpetrunic.healthmon.models.LocationModel;
import hr.fer.zpr.marinpetrunic.healthmon.models.weather.OpenWeatherResponse;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IEnvioronmentStatisticRepository;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.ILocationRepository;
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

    private static String QUERY_LAT_LONG_WEATHER = "http://api.openweathermap.org/data/2.5/weather?lat={0}&lon={1}&APPID={2}&units=metric";

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

    @Scheduled(cron = "0 0 10 * * *")
    public void obtainCityWeatherData() {
        for(LocationModel loc : locationRepository.all()) {
            EnvioronmentStatisticModel model = this.query(loc.getLat(), loc.getLon()).toEnvioronmentStatisticModel();
            model.setLocationId(loc.getId());
            envioronmentStatisticRepository.store(model);
        }
    }
}
