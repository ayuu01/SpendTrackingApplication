package com.example.SpendTrackingApplication.controller;

import com.example.SpendTrackingApplication.dao.WalletRepository;
import com.example.SpendTrackingApplication.init.BootstrapData;
import com.example.SpendTrackingApplication.request.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class WalletController {

    /*@Autowired
    private BootstrapData bootstrapData;

    @Autowired
    private WalletRepository walletRepository;

    @GetMapping("/user/wallet")
    public String viewWallet(@PathVariable(name = "id") String id) {

        return userService.viewWallet(id);
   }*/
}
