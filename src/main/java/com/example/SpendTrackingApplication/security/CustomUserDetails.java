package com.example.SpendTrackingApplication.security;

import com.example.SpendTrackingApplication.dao.RoleRepository;
import com.example.SpendTrackingApplication.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private User user;

    @Autowired
    private RoleRepository roleRepository;

    public CustomUserDetails(User user) {
        super();
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {


         SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(user.getRole().getName());
         return List.of(simpleGrantedAuthority);
        /*Role role=roleRepository.getRoleByName(RoleType.END_USER.name());

        if(role.getName()=="END_USER")
            return (Collection<? extends GrantedAuthority>) Collections.singleton(new SimpleGrantedAuthority("END_USER"));
        else {
            return (Collection<? extends GrantedAuthority>) Collections.singleton(new SimpleGrantedAuthority("SYSTEM_ADMIN"));
        }*/
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}