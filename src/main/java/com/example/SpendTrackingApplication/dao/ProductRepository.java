package com.example.SpendTrackingApplication.dao;

import com.example.SpendTrackingApplication.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,String> {

}
