package core.security.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import core.security.data.AuthRepository;
import core.security.models.Auth;


/**
 * UserAPI
 */
@RestController
@RequestMapping("/user")
@CrossOrigin  
public class UserAPI {

    @Autowired
    AuthRepository authRepository;


    @GetMapping(value="/profile")
    public Optional<Auth>  getMethodName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        System.out.println(name);
        return authRepository.findByUsername(name);
    }
    
}