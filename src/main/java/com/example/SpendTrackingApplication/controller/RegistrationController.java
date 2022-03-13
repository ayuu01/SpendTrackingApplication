package com.example.SpendTrackingApplication.controller;

import com.example.SpendTrackingApplication.business.RegistrationService;
import com.example.SpendTrackingApplication.request.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/registration")
    public void register(@RequestBody RegistrationRequest registrationRequest) {
        registrationService.register(registrationRequest);
    }

}
