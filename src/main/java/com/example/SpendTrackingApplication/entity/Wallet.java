package com.example.SpendTrackingApplication.entity;

import com.example.SpendTrackingApplication.utils.CommonUtils;

import javax.persistence.*;

@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    private String id;
    private String amount;
    private String walletType;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getWalletType() {
        return walletType;
    }

    public void setWalletType(String walletType) {
        this.walletType = walletType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
