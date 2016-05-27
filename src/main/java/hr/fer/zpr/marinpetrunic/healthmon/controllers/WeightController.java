package hr.fer.zpr.marinpetrunic.healthmon.controllers;

import hr.fer.zpr.marinpetrunic.healthmon.controllers.exceptions.ResourceNotFoundException;
import hr.fer.zpr.marinpetrunic.healthmon.controllers.requests.StoreWeightRequest;
import hr.fer.zpr.marinpetrunic.healthmon.models.WeightModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IWeightsRepository;
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
@RequestMapping("/api/v1/weights")
public class WeightController extends BaseController {

    @Autowired
    private IWeightsRepository weightRepository;

    @PreAuthorize(USER)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<WeightModel> all(
            @RequestParam(name = "from", required = false)LocalDateTime from,
            @RequestParam(name = "to", required = false)LocalDateTime to) {
        return weightRepository.getUsersWeights(this.getLoggedUser().getId(), from, to);
    }

    @PreAuthorize(USER)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public WeightModel get(@PathVariable Integer id) {
        WeightModel entity = weightRepository.getUserWeight(id);
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
    public WeightModel store(@Valid @RequestBody StoreWeightRequest request) {
        WeightModel model = request.toWeightModel();
        model.setUserId(this.getLoggedUser().getId());
        model = weightRepository.store(model);
        return model;
    }

    @PreAuthorize(USER)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public WeightModel delete(@PathVariable Integer id) {
        WeightModel entity = weightRepository.getUserWeight(id);
        if(entity == null) {
            throw new ResourceNotFoundException();
        }
        if(!getLoggedUser().getId().equals(entity.getUserId())) {
            throw new AccessDeniedException("You are not owner of this resource");
        }
        weightRepository.delete(id);
        return entity;
    }
}
