//package com.example.SpendTrackingApplication.controller;
//
//import com.example.SpendTrackingApplication.business.MyService;
//import com.example.SpendTrackingApplication.business.RegistrationService;
//import com.example.SpendTrackingApplication.entity.Product;
//import com.example.SpendTrackingApplication.entity.User;
//import com.example.SpendTrackingApplication.entity.UserWallet;
//import com.example.SpendTrackingApplication.request.RegistrationRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class MyController {
//
//     @Autowired
//      private MyService userService;
//
//
//    @GetMapping("/user")
//    public List<User> getAllUser() {
//        return userService.getAllUser();
//    }
//
//    @PostMapping("/user")
//    public User add(@RequestBody User user) {
//        return userService.createUser(user);
//    }
//
//    @GetMapping("/user/{id}")
//    public Optional<User> getById(@PathVariable(name = "id") String id) {
//        return userService.getById(id);
//    }
//
//    @PutMapping("/user/{id}")
//    public User update(@RequestBody User user, @PathVariable String id) {
//        return userService.updateProfile(user, id);
//    }
//
//    @PostMapping("/user/wallet")
//    public UserWallet addWallet(@RequestBody UserWallet userWallet) {
//        return userService.createUserWallet(userWallet);
//    }
//
//    @GetMapping("/user/wallet")
//    public List<UserWallet> getUserWallet() {
//        return userService.getUserWallet();
//    }
//
//    @GetMapping("/user/balance/{id}")
//    public String viewWallet(@PathVariable(name = "id") String id) {
//
//        return userService.viewWallet(id);
//    }
//
//    @PostMapping("/product")
//    public Product addProduct(@RequestBody Product product){
//        return userService.addProduct(product);
//    }
//
//    @GetMapping("/product/{id}")
//    public Optional<Product> getByName(@PathVariable("id") String id){
//        return userService.getByName(id);
//    }
//
//    @GetMapping("/product")
//    public List<Product> getAllProduct(){
//        return userService.getAllProduct();
//    }
//}