package hr.fer.zpr.marinpetrunic.healthmon.controllers;

import hr.fer.zpr.marinpetrunic.healthmon.models.ActivityModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MarinPetrunic
 */
@RestController
@RequestMapping("/api/v1/activities")
public class ActivityController extends BaseController {

    @Autowired
    private IActivityRepository activityRepository;

    @PreAuthorize(USER)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<ActivityModel> all() {
        return activityRepository.all();
    }
}
