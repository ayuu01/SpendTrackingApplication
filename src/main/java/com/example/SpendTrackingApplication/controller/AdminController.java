package com.example.SpendTrackingApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AdminController {

    @GetMapping("/admin")
    public String home(){
        return "Welcome";
    }
}
