package com.example.SpendTrackingApplication.business;

import com.example.SpendTrackingApplication.MongoRepository.PurchaseRepository;
import com.example.SpendTrackingApplication.dao.UserRepository;
import com.example.SpendTrackingApplication.dao.UserWalletRepository;
import com.example.SpendTrackingApplication.entity.User;
import com.example.SpendTrackingApplication.entity.UserWallet;
import com.example.SpendTrackingApplication.model.Purchase;
import com.example.SpendTrackingApplication.request.RegistrationRequest;
import com.example.SpendTrackingApplication.response.PurchaseResponse;
import com.example.SpendTrackingApplication.response.UserResponse;
import com.example.SpendTrackingApplication.response.UserWalletResponse;
import com.example.SpendTrackingApplication.utils.CommonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserWalletRepository userWalletRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    public void updateProfile(RegistrationRequest registrationRequest,String username) throws ValidationException {

        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        User userDetails = user.get();

        if(!user.isPresent()){
            throw new ValidationException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "configuration does not exists for username::" + username);
        }
        if (!(userDetails.getUsername().equals(registrationRequest.getUsername()) )) {
            userDetails.setUsername(registrationRequest.getUsername());
        }
        if (!(userDetails.getFirstName().equals(registrationRequest.getFirstName()) )) {
            userDetails.setFirstName(registrationRequest.getFirstName());
        }

        if (!(userDetails.getLastName().equals(registrationRequest.getLastName()) )) {
            userDetails.setLastName(registrationRequest.getLastName());
        }
        if (!(userDetails.getEmail().equals(registrationRequest.getEmail()) )) {
            userDetails.setEmail(registrationRequest.getEmail());
        }
        if (!(userDetails.getPassword().equals(registrationRequest.getPassword()) )) {
            userDetails.setPassword(registrationRequest.getPassword());
        }
        if (!(userDetails.getMobileNo().equals(registrationRequest.getMobileNo()) )) {
            userDetails.setMobileNo(registrationRequest.getMobileNo());
        }
        if (!(userDetails.getCity().equals(registrationRequest.getCity()) )) {
            userDetails.setCity(registrationRequest.getCity());
        }
        if (!(userDetails.getActive().equals(registrationRequest.getActive()) )) {
            userDetails.setActive(registrationRequest.getActive());
        }

        CommonUtils.setUpdateEntityFields(user);
        userRepository.save(userDetails);
    }

    public UserWalletResponse viewWallet(String id) {

        Optional<User> user = (Optional<User>)userRepository.findById(id);
        User userDetails = user.get();
        UserWallet userWallet= userWalletRepository.getUserWallet(userDetails.getId());
        UserWalletResponse userWalletResponse=new UserWalletResponse();
        BeanUtils.copyProperties(userWallet,userWalletResponse);
        return userWalletResponse;
    }

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

    public Optional<Purchase> viewPurchase(String purchaseId) {
        Optional<Purchase> purchase = purchaseRepository.findById(purchaseId);
        return purchase;
        /*Optional<Purchase> purchase = purchaseRepository.findById(purchaseId);
        PurchaseResponse purchaseResponse=new PurchaseResponse();
        BeanUtils.copyProperties(purchase,purchaseResponse);
        return purchaseResponse;*/
    }
}
