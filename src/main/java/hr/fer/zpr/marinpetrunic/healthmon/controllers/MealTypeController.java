package hr.fer.zpr.marinpetrunic.healthmon.controllers;

import hr.fer.zpr.marinpetrunic.healthmon.models.MealTypeModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IMealTypeRepository;
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
@RequestMapping("/api/v1/meal-types")
public class MealTypeController extends BaseController {

    @Autowired
    private IMealTypeRepository mealTypeRepository;

    @PreAuthorize(USER)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<MealTypeModel> all() {
        return mealTypeRepository.all();
    }


}
