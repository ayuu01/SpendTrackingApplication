package com.example.SpendTrackingApplication.business;

import com.example.SpendTrackingApplication.dao.UserRepository;
import com.example.SpendTrackingApplication.entity.User;
import com.example.SpendTrackingApplication.request.RegistrationRequest;
import com.example.SpendTrackingApplication.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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

    public void viewWallet(){

    }
}
