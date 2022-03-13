package com.example.SpendTrackingApplication.business;

import com.example.SpendTrackingApplication.MongoRepository.PurchaseRepository;
import com.example.SpendTrackingApplication.dao.ProductRepository;
import com.example.SpendTrackingApplication.dao.UserRepository;
import com.example.SpendTrackingApplication.entity.Product;
import com.example.SpendTrackingApplication.entity.User;
import com.example.SpendTrackingApplication.model.Purchase;
import com.example.SpendTrackingApplication.request.PurchaseRequest;
import com.example.SpendTrackingApplication.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public void madePurchase(PurchaseRequest purchaseRequest) {
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(CommonUtils.generateUUID());
        CommonUtils.setCreateEntityFields(purchase);
        CommonUtils.setUpdateEntityFields(purchase);
        purchase.setAddress(purchaseRequest.getAddress());
        User user= userRepository.findById(purchaseRequest.getUserId()).get();
        purchase.setUser(user);

        Product product= productRepository.findById(purchaseRequest.getProductId()).get();
        purchase.setProduct(product);

        purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllPurchases() {
        List<Purchase> purchase=  purchaseRepository.findAll();
        return purchase;
    }
}
