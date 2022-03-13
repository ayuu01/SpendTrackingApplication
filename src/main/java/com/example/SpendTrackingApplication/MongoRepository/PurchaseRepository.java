package com.example.SpendTrackingApplication.MongoRepository;

import com.example.SpendTrackingApplication.model.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PurchaseRepository  extends MongoRepository<Purchase,String> {
}
