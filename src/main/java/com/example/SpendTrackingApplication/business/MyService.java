//package com.example.SpendTrackingApplication.business;
//
//import com.example.SpendTrackingApplication.dao.ProductRepository;
//import com.example.SpendTrackingApplication.dao.UserRepository;
//import com.example.SpendTrackingApplication.dao.UserWalletRepository;
//import com.example.SpendTrackingApplication.entity.Product;
//import com.example.SpendTrackingApplication.entity.User;
//import com.example.SpendTrackingApplication.entity.UserWallet;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class MyService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserWalletRepository userWalletRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    public User createUser(User user){
//
//        return userRepository.save(user);
//    }
//
//    public UserWallet createUserWallet(UserWallet userWallet){
//        return userWalletRepository.save(userWallet);
//    }
//
//    public List<User> getAllUser(){
//        List<User>list=(List<User>) this.userRepository.findAll();
//        return list;
//    }
//    public List<UserWallet> getUserWallet(){
//        List<UserWallet>list=(List<UserWallet>) this.userWalletRepository.findAll();
//        return list;
//    }
//
//    public Optional<User> getById(String id){
//        return userRepository.findById(id);
//    }
//
//    public User updateProfile( User user,String id){
//        return  userRepository.save(user);
//    }
//
//    public String viewWallet( String id) {
//        return userWalletRepository.getBalance(id);
//    }
//
//    public Product addProduct(Product product){
//        return productRepository.save(product);
//    }
//
//    public Optional<Product> getByName(String id){
//        return productRepository.findById(id);
//    }
//    public List<Product> getAllProduct(){
//        List<Product>list=(List<Product>) this.productRepository.findAll();
//        return list;
//    }
//
//}