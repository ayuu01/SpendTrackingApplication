package com.example.SpendTrackingApplication.dao;

import com.example.SpendTrackingApplication.entity.Product;
import com.example.SpendTrackingApplication.response.ProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {

    @Query(value="From Product where category=:category")
    List<Product> viewProductsAccToCategory(@Param("category") String category);


    //@Query(value = "FROM Product where name=:name")
    //Product getProductByName(@Param("name") String name);


   // @Query(value = "delete from product where name=:name",nativeQuery = true)
   // Product deleteProductByName(@Param("name") String name);
}
