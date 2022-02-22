package com.example.SpendTrackingApplication.dao;

import com.example.SpendTrackingApplication.entity.ProductStock;
import org.springframework.data.repository.CrudRepository;

public interface ProductStockRepository extends CrudRepository<ProductStock,String> {
}
