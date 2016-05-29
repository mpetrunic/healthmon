package hr.fer.zpr.marinpetrunic.healthmon.controllers;

import hr.fer.zpr.marinpetrunic.healthmon.models.EnvioronmentStatisticModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IEnvioronmentStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MarinPetrunic
 */
@RestController
@RequestMapping("/api/v1/locations/{locationId}/weathers")
public class WeatherController extends BaseController {

    @Autowired
    private IEnvioronmentStatisticRepository envioronmentStatisticRepository;

    @PreAuthorize(USER)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<EnvioronmentStatisticModel> all(@PathVariable Integer locationId) {
        return envioronmentStatisticRepository.all(locationId);
    }
}
