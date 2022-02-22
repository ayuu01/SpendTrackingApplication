package com.example.SpendTrackingApplication.business;

import com.example.SpendTrackingApplication.dao.RoleRepository;
import com.example.SpendTrackingApplication.dao.UserRepository;
import com.example.SpendTrackingApplication.dao.UserWalletRepository;
import com.example.SpendTrackingApplication.dao.WalletRepository;
import com.example.SpendTrackingApplication.entity.Role;
import com.example.SpendTrackingApplication.entity.User;
import com.example.SpendTrackingApplication.entity.UserWallet;
import com.example.SpendTrackingApplication.entity.Wallet;
import com.example.SpendTrackingApplication.enums.RoleType;
import com.example.SpendTrackingApplication.enums.WalletType;
import com.example.SpendTrackingApplication.request.RegistrationRequest;
import com.example.SpendTrackingApplication.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserWalletRepository userWalletRepository;

    public void register(RegistrationRequest registrationRequest) {
        User user = new User();
        user.setId(CommonUtils.generateUUID());
        user.setUsername(registrationRequest.getUsername());
        user.setFirstName(registrationRequest.getFirstName());
        user.setLastName(registrationRequest.getLastName());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(registrationRequest.getPassword());
        user.setMobileNo(registrationRequest.getMobileNo());
        user.setCity(registrationRequest.getCity());
        user.setActive(registrationRequest.getActive());
        CommonUtils.setCreateEntityFields(user);
        CommonUtils.setUpdateEntityFields(user);

        //Wallet wallet=walletRepository.findById(registrationRequest.getWalletId()).get();
        Wallet wallet=walletRepository.getWalletByName(WalletType.BASIC.getName());
        Role role=roleRepository.getRoleByName(RoleType.END_USER.name());

        user.setRole(role);
        user.setWallet(wallet);
        userRepository.save(user);

        UserWallet userWallet= new UserWallet();

        userWallet.setId(CommonUtils.generateUUID());
        userWallet.setBalance(wallet.getAmount());
        userWallet.setUser(user);
        userWallet.setWallet(wallet);

        userWalletRepository.save(userWallet);
    }
}
