package com.example.SpendTrackingApplication.dao;

import com.example.SpendTrackingApplication.entity.User;
import com.example.SpendTrackingApplication.entity.UserWallet;
import com.example.SpendTrackingApplication.response.UserWalletResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserWalletRepository extends JpaRepository<UserWallet,String> {

     //@Query(value= "select * from user_wallet join user on user_wallet.user_id=user.id;",nativeQuery = true)
     @Query(value="From UserWallet where USER_ID=:id")
     UserWallet getUserWallet(@Param("id") String id);
}