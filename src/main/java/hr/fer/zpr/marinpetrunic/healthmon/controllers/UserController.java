package hr.fer.zpr.marinpetrunic.healthmon.controllers;

import hr.fer.zpr.marinpetrunic.healthmon.models.UserModel;
import hr.fer.zpr.marinpetrunic.healthmon.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author MarinPetrunic
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PreAuthorize(value = "hasAuthority('USER')")
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserModel user() {
        return userRepository.getByUsername("user");
    }

}
