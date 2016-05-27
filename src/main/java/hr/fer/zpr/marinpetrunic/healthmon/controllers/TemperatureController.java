package hr.fer.zpr.marinpetrunic.healthmon.controllers;

import hr.fer.zpr.marinpetrunic.healthmon.controllers.exceptions.ResourceNotFoundException;
import hr.fer.zpr.marinpetrunic.healthmon.controllers.requests.StoreTemperatureRequest;
import hr.fer.zpr.marinpetrunic.healthmon.models.TemperatureModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.ITemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author MarinPetrunic
 */
@RestController
@RequestMapping("/api/v1/temperatures")
public class TemperatureController extends BaseController {

    @Autowired
    private ITemperatureRepository temperatureRepository;

    @PreAuthorize(USER)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<TemperatureModel> all(@RequestParam(name = "from", required = false)LocalDateTime from, @RequestParam(name = "to", required = false)LocalDateTime to) {
        return temperatureRepository.getUserTemperatures(this.getLoggedUser().getId(), from, to);
    }

    @PreAuthorize(USER)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public TemperatureModel get(@PathVariable Integer id) {
        TemperatureModel entity = temperatureRepository.getTemperature(id);
        if(entity == null) {
            throw new ResourceNotFoundException();
        }
        if(!getLoggedUser().getId().equals(entity.getUserId())) {
            throw new AccessDeniedException("You are not owner of this resource");
        }
        return entity;
    }

    @PreAuthorize(USER)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public TemperatureModel store(@Valid @RequestBody StoreTemperatureRequest request) {
        TemperatureModel model = request.toTemperatureModel();
        model.setUserId(this.getLoggedUser().getId());
        model = temperatureRepository.store(model);
        return model;
    }

    @PreAuthorize(USER)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public TemperatureModel delete(@PathVariable Integer id) {
        TemperatureModel entity = temperatureRepository.getTemperature(id);
        if(entity == null) {
            throw new ResourceNotFoundException();
        }
        if(!getLoggedUser().getId().equals(entity.getUserId())) {
            throw new AccessDeniedException("You are not owner of this resource");
        }
        temperatureRepository.delete(id);
        return entity;
    }
}
