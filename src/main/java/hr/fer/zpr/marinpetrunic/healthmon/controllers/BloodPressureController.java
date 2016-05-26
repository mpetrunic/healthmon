package hr.fer.zpr.marinpetrunic.healthmon.controllers;

import hr.fer.zpr.marinpetrunic.healthmon.controllers.exceptions.ResourceNotFoundException;
import hr.fer.zpr.marinpetrunic.healthmon.controllers.requests.StoreBloodPressureRequest;
import hr.fer.zpr.marinpetrunic.healthmon.models.BloodPressureModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IBloodPressureRepository;
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
@RequestMapping("/api/v1/blood-pressures")
public class BloodPressureController extends BaseController {

    @Autowired
    private IBloodPressureRepository bloodPressureRepository;

    @PreAuthorize(USER)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<BloodPressureModel> all(@RequestParam(name = "from", required = false)LocalDateTime from, @RequestParam(name = "to", required = false)LocalDateTime to) {
        return bloodPressureRepository.getUsersBloodPressures(this.getLoggedUser().getId(), from, to);
    }

    @PreAuthorize(USER)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public BloodPressureModel get(@PathVariable Integer id) {
        BloodPressureModel entity = bloodPressureRepository.getBloodPressure(id);
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
    public BloodPressureModel store(@Valid @RequestBody StoreBloodPressureRequest request) {
        BloodPressureModel model = request.toBloodPressureModel();
        model.setUserId(this.getLoggedUser().getId());
        model = bloodPressureRepository.store(model);
        return model;
    }

    @PreAuthorize(USER)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public BloodPressureModel delete(@PathVariable Integer id) {
        BloodPressureModel entity = bloodPressureRepository.getBloodPressure(id);
        if(entity == null) {
            throw new ResourceNotFoundException();
        }
        if(!getLoggedUser().getId().equals(entity.getUserId())) {
            throw new AccessDeniedException("You are not owner of this resource");
        }
        bloodPressureRepository.delete(id);
        return entity;
    }


}
