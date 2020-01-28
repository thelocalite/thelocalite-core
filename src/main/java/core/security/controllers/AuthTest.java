package core.security.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * AuthTest
 */
@RestController
@CrossOrigin
public class AuthTest {

    @RequestMapping(value="/testauth", method=RequestMethod.GET)
    public String authtest() {
        return "{\"message\" : \"Hello Auth\"}";
    }
    
}