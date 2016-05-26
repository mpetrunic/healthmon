package hr.fer.zpr.marinpetrunic.healthmon.controllers;

import hr.fer.zpr.marinpetrunic.healthmon.controllers.exceptions.ResourceNotFoundException;
import hr.fer.zpr.marinpetrunic.healthmon.models.UserModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import hr.fer.zpr.marinpetrunic.healthmon.controllers.requests.StoreUserRequest;

import javax.validation.Valid;
import java.security.Principal;

/**
 * @author MarinPetrunic
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController extends BaseController {

    @Autowired
    private IUserRepository userRepository;

    @PreAuthorize(USER)
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public Principal user(Principal user) {
        return user;
    }

    @PreAuthorize(ALLOW_ALL)
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String user(@PathVariable String username) {
        UserModel user = userRepository.getByUsername(username);
        if(user == null) {
            throw new ResourceNotFoundException();
        }
        return user.getUsername();
    }

    @PreAuthorize(ALLOW_ALL)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public UserModel store(@Valid @RequestBody StoreUserRequest request) {
        return userRepository.storeUser(request.toUserModel());
    }

}
