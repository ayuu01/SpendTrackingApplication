package com.example.SpendTrackingApplication.response;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class UserResponse {
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String mobileNo;
    private String city;
    private Boolean active;

    @OneToOne
    @JoinColumn(name = "WALLET_ID")
    private String WalletId;

    @OneToOne
    @JoinColumn(name = "ROLE_ID")
    private String RollId;

    public String getRollId() {
        return RollId;
    }

    public void setRollId(String rollId) {
        RollId = rollId;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWalletId() {
        return WalletId;
    }

    public void setWalletId(String walletId) {
        WalletId = walletId;
    }
}

