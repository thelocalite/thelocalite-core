package core.security.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import core.payload.ResponseMessage;
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
    public Optional<Auth>  getProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        System.out.println(name);
        return authRepository.findByUsername(name);
    }

    @PostMapping(value="/update-address")
    public ResponseMessage updateAddress(@RequestBody Map<String, String> body){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        Auth user = authRepository.findByUsername(name).orElse(null);

        if(user != null){
            user.setAddress(body.get("address"));
            user.setLatitude(Double.parseDouble(body.get("lat")));
            user.setLongitude(Double.parseDouble(body.get("lng")));
            authRepository.save(user);
            return new ResponseMessage("succesfully updated location");
        }else{
            return new ResponseMessage("user not found");
        }
    }
    

    @PostMapping(value="/update-profile")
    public ResponseMessage updateProfile(@RequestBody Map<String, String> body){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        System.out.println(name);

        Auth user = authRepository.findByUsername(name).orElse(null);


        if(user != null){
            user.setName(body.get("name"));
            user.setContactNumber(body.get("userContact"));
            authRepository.save(user);
            return new ResponseMessage("updated profile successfully");
        }else{
            return new ResponseMessage("failed to update profile");
        }


    }
}