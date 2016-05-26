package hr.fer.zpr.marinpetrunic.healthmon.controllers;

import hr.fer.zpr.marinpetrunic.healthmon.controllers.exceptions.ResourceNotFoundException;
import hr.fer.zpr.marinpetrunic.healthmon.controllers.requests.StoreHeartRateRequest;
import hr.fer.zpr.marinpetrunic.healthmon.models.HeartRateModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IHeartRateRepository;
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
@RequestMapping("/api/v1/heart-rates")
public class HeartRateController extends BaseController {

    @Autowired
    private IHeartRateRepository heartRateRepository;

    @PreAuthorize(USER)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<HeartRateModel> all(@RequestParam(name = "from", required = false)LocalDateTime from, @RequestParam(name = "to", required = false)LocalDateTime to) {
        return heartRateRepository.getUsersHeartRates(this.getLoggedUser().getId(), from, to);
    }

    @PreAuthorize(USER)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public HeartRateModel get(@PathVariable Integer id) {
        HeartRateModel entity = heartRateRepository.getHeartRate(id);
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
    public HeartRateModel store(@Valid @RequestBody StoreHeartRateRequest request) {
        HeartRateModel model = request.toHeartRateModel();
        model.setUserId(this.getLoggedUser().getId());
        model = heartRateRepository.store(model);
        return model;
    }

    @PreAuthorize(USER)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public HeartRateModel delete(@PathVariable Integer id) {
        HeartRateModel entity = heartRateRepository.getHeartRate(id);
        if(entity == null) {
            throw new ResourceNotFoundException();
        }
        if(!getLoggedUser().getId().equals(entity.getUserId())) {
            throw new AccessDeniedException("You are not owner of this resource");
        }
        heartRateRepository.delete(id);
        return entity;
    }
}
