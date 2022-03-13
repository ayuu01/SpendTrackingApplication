package com.example.SpendTrackingApplication.controller;

import com.example.SpendTrackingApplication.business.PurchaseService;
import com.example.SpendTrackingApplication.business.UserService;
import com.example.SpendTrackingApplication.dao.UserRepository;
import com.example.SpendTrackingApplication.model.Purchase;
import com.example.SpendTrackingApplication.request.PurchaseRequest;
import com.example.SpendTrackingApplication.request.RegistrationRequest;
import com.example.SpendTrackingApplication.response.UserWalletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PurchaseService purchaseService;

    @PutMapping("/user/update/{username}")
    public void updateProfile(@RequestBody RegistrationRequest registrationRequest,@PathVariable String username ) throws ValidationException {
        userService.updateProfile(registrationRequest,username);
    }

    @GetMapping("/user/balance/{id}")
    public UserWalletResponse viewWallet(@PathVariable(name = "id") String id) {
        return userService.viewWallet(id);
    }

    @PostMapping(value = "/madePurchases")
    public String madePurchase(@RequestBody PurchaseRequest purchaseRequest)
    {
        purchaseService.madePurchase( purchaseRequest);
        return "New Purchase is made";
    }

//    @GetMapping("user/viewPurchases/{purchaseId}")
//    public PurchaseResponse viewPurchaseById(@RequestParam(value = "purchaseId") String purchaseId){
//        PurchaseResponse purchaseResponse=userService.viewPurchase(purchaseId);
//        return purchaseResponse;
//    }


    @GetMapping("user/viewPurchases/{purchaseId}")
    public Optional<Purchase> viewPurchaseById(@RequestParam(value = "purchaseId") String purchaseId){
        Optional<Purchase> purchase=userService.viewPurchase(purchaseId);
        return purchase;
    }
}
