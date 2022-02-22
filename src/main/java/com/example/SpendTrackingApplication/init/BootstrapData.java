package com.example.SpendTrackingApplication.init;

import com.example.SpendTrackingApplication.dao.RoleRepository;
import com.example.SpendTrackingApplication.dao.UserRepository;
import com.example.SpendTrackingApplication.dao.WalletRepository;
import com.example.SpendTrackingApplication.entity.Role;
import com.example.SpendTrackingApplication.entity.User;
import com.example.SpendTrackingApplication.entity.Wallet;
import com.example.SpendTrackingApplication.enums.RoleType;
import com.example.SpendTrackingApplication.enums.WalletType;
import com.example.SpendTrackingApplication.utils.CommonUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class BootstrapData implements InitializingBean {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

        if (roleRepository.findAll().isEmpty()) {

            List<Role> roleList = new ArrayList<>();

            Role endUser = new Role();
            endUser.setId(CommonUtils.generateUUID());
            endUser.setName(RoleType.END_USER.name());
            endUser.setDescription("This is End User Role");
            roleList.add(endUser);

            Role admin = new Role();
            admin.setId(CommonUtils.generateUUID());
            admin.setName(RoleType.SYSTEM_ADMIN.name());
            admin.setDescription("This is admin");
            roleList.add(admin);

            roleRepository.saveAll(roleList);
        }

        if (walletRepository.findAll().isEmpty()) {

            List<Wallet> walletList = new ArrayList<>();

            Wallet basic = new Wallet();
            basic.setId(CommonUtils.generateUUID());
            basic.setAmount(WalletType.BASIC.getAmount().toString());
            basic.setWalletType(WalletType.BASIC.getName());
            basic.setDescription("This is basic amount");
            walletList.add(basic);

            Wallet standard = new Wallet();
            standard.setId(CommonUtils.generateUUID());
            standard.setAmount(WalletType.STANDARD.getAmount().toString());
            standard.setWalletType(WalletType.STANDARD.getName());
            standard.setDescription("This is standard amount");
            walletList.add(standard);

            Wallet premium = new Wallet();
            premium.setId(CommonUtils.generateUUID());
            premium.setAmount(WalletType.PREMIUM.getAmount().toString());
            premium.setWalletType(WalletType.PREMIUM.getName());
            premium.setDescription("This is premium amount");
            walletList.add(premium);

            walletRepository.saveAll(walletList);
        }

        if (userRepository.findAll().isEmpty()) {
            Role role=roleRepository.getRoleByName(RoleType.SYSTEM_ADMIN.name());

            User admin = new User();
            admin.setId(CommonUtils.generateUUID());
            admin.setUsername("admin01");
            admin.setFirstName("Admin");
            admin.setLastName("Agrawal");
            admin.setEmail("admin@gamil.com");
            admin.setPassword("123");
            admin.setMobileNo("989786878");
            admin.setCity("agra");
            admin.setActive(true);
            admin.setRole(role);
            CommonUtils.setCreateEntityFields(admin);
            CommonUtils.setUpdateEntityFields(admin);

            userRepository.save(admin);
        }
    }
}
