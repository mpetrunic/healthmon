package hr.fer.zpr.marinpetrunic.healthmon.controllers;

import hr.fer.zpr.marinpetrunic.healthmon.controllers.requests.StoreUserMealsRequest;
import hr.fer.zpr.marinpetrunic.healthmon.models.UserMealModel;
import hr.fer.zpr.marinpetrunic.healthmon.models.UserMealsByDayModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IUserMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

/**
 * @author MarinPetrunic
 */
@RestController
@RequestMapping("/api/v1/user-meals")
public class UserMealsController extends BaseController {

    @Autowired
    private IUserMealRepository userMealRepository;

    @PreAuthorize(USER)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<UserMealsByDayModel> get(
            @RequestParam(name = "from", required = false) LocalDate from,
            @RequestParam(name = "to", required = false) LocalDate to
    ) {
        return userMealRepository.all(this.getLoggedUser().getId(), from, to);
    }

    @PreAuthorize(USER)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public UserMealModel store(@Valid @RequestBody StoreUserMealsRequest request) {
        UserMealModel model = request.toUserMealModel();
        model.setUserId(this.getLoggedUser().getId());
        return userMealRepository.store(model);
    }

}
