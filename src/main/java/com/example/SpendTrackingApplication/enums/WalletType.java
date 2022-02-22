package com.example.SpendTrackingApplication.enums;

public enum WalletType {
    BASIC(50000L, "BASIC"),STANDARD(80000L,"STANDARD"),PREMIUM(100000L,"PREMIUM");

    private Long amount;
    private String name;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    WalletType(Long amount, String name) {
        this.amount = amount;
        this.name = name;
    }
}
