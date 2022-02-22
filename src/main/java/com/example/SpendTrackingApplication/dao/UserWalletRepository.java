package com.example.SpendTrackingApplication.dao;

import com.example.SpendTrackingApplication.entity.User;
import com.example.SpendTrackingApplication.entity.UserWallet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserWalletRepository extends CrudRepository<UserWallet,String>{

     // @Query(value= "select balance from user_wallet join user on user_wallet.id=user.id;",nativeQuery = true)
     //String getBalance(@Param("id") String id);
}