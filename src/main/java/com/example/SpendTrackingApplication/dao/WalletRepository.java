package com.example.SpendTrackingApplication.dao;

import com.example.SpendTrackingApplication.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WalletRepository extends JpaRepository<Wallet,String> {

    @Query(value="From Wallet where walletType=:walletType")
    Wallet getWalletByName(@Param("walletType") String name);




}
