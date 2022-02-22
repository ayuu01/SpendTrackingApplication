package com.example.SpendTrackingApplication.controller;

import com.example.SpendTrackingApplication.business.RegistrationService;
import com.example.SpendTrackingApplication.business.UserService;
import com.example.SpendTrackingApplication.dao.UserRepository;
import com.example.SpendTrackingApplication.entity.User;
import com.example.SpendTrackingApplication.entity.UserWallet;
import com.example.SpendTrackingApplication.request.RegistrationRequest;
import com.example.SpendTrackingApplication.response.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/registration")
    public void register(@RequestBody RegistrationRequest registrationRequest) {
        registrationService.register(registrationRequest);
    }

    /*@GetMapping("/user/registration")
    public List<User> registrationRequest(){
        List<User> list=(List<User>) userRepository.findAll();
        return list;
    }*/


    @GetMapping("/user/registration")
    public List<UserResponse> getUsers(){
        List<UserResponse> list= new ArrayList<>();
        List<User> response= (List<User>) userRepository.findAll();
        response.forEach(element -> {
            UserResponse userResponse= new UserResponse();
            BeanUtils.copyProperties(element, userResponse);
            list.add(userResponse);
        });
        return list;
    }

    @PutMapping("/user/update/{username}")
    public void updateProfile(@RequestBody RegistrationRequest registrationRequest,@PathVariable String username ) throws ValidationException {
        userService.updateProfile(registrationRequest,username);
    }

    @GetMapping("/user/viewWallet")
    public void viewWallets(){
       userService.viewWallet();
    }


}
