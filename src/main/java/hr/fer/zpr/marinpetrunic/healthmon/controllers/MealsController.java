package hr.fer.zpr.marinpetrunic.healthmon.controllers;

import hr.fer.zpr.marinpetrunic.healthmon.controllers.exceptions.ResourceNotFoundException;
import hr.fer.zpr.marinpetrunic.healthmon.models.MealModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MarinPetrunic
 */
@RestController
@RequestMapping("/api/v1/meals")
public class MealsController extends BaseController {

    @Autowired
    private IMealRepository mealRepository;

    @PreAuthorize(USER)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<MealModel> query(
            @RequestParam(name = "query", defaultValue = "") String query,
            @RequestParam(name = "limit", defaultValue = "10") Integer limit) {
        return mealRepository.query(query, limit);
    }

    @PreAuthorize(USER)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public MealModel get(@PathVariable Integer id) {
        MealModel meal =  mealRepository.get(id);
        if(meal == null) {
            throw new ResourceNotFoundException();
        }
        return meal;
    }

}
