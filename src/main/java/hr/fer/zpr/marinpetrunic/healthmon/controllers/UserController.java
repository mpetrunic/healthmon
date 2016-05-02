package hr.fer.zpr.marinpetrunic.healthmon.controllers;

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

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public Principal user(Principal user) {
        return user;
    }

}
