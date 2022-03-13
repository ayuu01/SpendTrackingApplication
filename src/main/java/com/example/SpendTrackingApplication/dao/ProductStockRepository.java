package com.example.SpendTrackingApplication.dao;

import com.example.SpendTrackingApplication.entity.Product;
import com.example.SpendTrackingApplication.entity.ProductStock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductStockRepository extends CrudRepository<ProductStock,String> {

   // @Query(value = "delete from product_stock where name=:name",nativeQuery = true)
   //  Product deleteProductByName(@Param("name") String name);


}
