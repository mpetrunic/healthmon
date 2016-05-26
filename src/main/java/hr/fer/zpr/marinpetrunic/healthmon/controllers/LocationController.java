package hr.fer.zpr.marinpetrunic.healthmon.controllers;

import hr.fer.zpr.marinpetrunic.healthmon.controllers.exceptions.ResourceNotFoundException;
import hr.fer.zpr.marinpetrunic.healthmon.models.LocationModel;
import hr.fer.zpr.marinpetrunic.healthmon.models.UserModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.ILocationRepository;
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
@RequestMapping("/api/v1/locations")
public class LocationController extends BaseController {

    @Autowired
    private ILocationRepository locationRepository;

    @PreAuthorize(ALLOW_ALL)
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<LocationModel> locations() {
        return locationRepository.all();
    }

    @PreAuthorize(ALLOW_ALL)
    @RequestMapping(value = "/{identification}", method = RequestMethod.GET)
    public LocationModel location(@PathVariable String identification) {
        try {
            Integer id = Integer.parseInt(identification);
            return locationRepository.get(id);
        } catch(NumberFormatException ignored){}
        return locationRepository.get(identification);
    }

}
