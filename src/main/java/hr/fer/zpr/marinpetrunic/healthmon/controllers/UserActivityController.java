package hr.fer.zpr.marinpetrunic.healthmon.controllers;

import hr.fer.zpr.marinpetrunic.healthmon.controllers.exceptions.ResourceNotFoundException;
import hr.fer.zpr.marinpetrunic.healthmon.controllers.requests.StoreUserActivityRequest;
import hr.fer.zpr.marinpetrunic.healthmon.models.UserActivityModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IUserActivityRepository;
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
@RequestMapping("/api/v1/user-activities")
public class UserActivityController extends BaseController {

    @Autowired
    private IUserActivityRepository userActivityRepository;

    @PreAuthorize(USER)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<UserActivityModel> all(
            @RequestParam(name = "from", required = false) LocalDateTime from,
            @RequestParam(name = "to", required = false) LocalDateTime to
    ) {
        return userActivityRepository.all(this.getLoggedUser().getId(), from, to);
    }

    @PreAuthorize(USER)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public UserActivityModel store(@Valid @RequestBody StoreUserActivityRequest request) {
        UserActivityModel model = request.toUserActivityModel();
        model.setUserId(this.getLoggedUser().getId());
        return userActivityRepository.store(model);
    }

    @PreAuthorize(USER)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public UserActivityModel store(@PathVariable Integer id) {
        UserActivityModel entity = userActivityRepository.get(id);
        if(entity == null) {
            throw new ResourceNotFoundException();
        }
        if(!getLoggedUser().getId().equals(entity.getUserId())) {
            throw new AccessDeniedException("You are not owner of this resource");
        }
        userActivityRepository.delete(id);
        return entity;
    }

}
