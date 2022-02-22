package com.example.SpendTrackingApplication.business;

import com.example.SpendTrackingApplication.dao.ProductRepository;
import com.example.SpendTrackingApplication.dao.ProductStockRepository;
import com.example.SpendTrackingApplication.entity.ParentEntity;
import com.example.SpendTrackingApplication.entity.Product;
import com.example.SpendTrackingApplication.entity.ProductStock;
import com.example.SpendTrackingApplication.request.ProductRequest;
import com.example.SpendTrackingApplication.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductStockRepository productStockRepository;
    private ParentEntity parentEntity;

    public void product(ProductRequest productRequest) {

        Product product = new Product();
        product.setId(CommonUtils.generateUUID());
        product.setName(productRequest.getName());
        product.setCategory(productRequest.getCategory());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        productRepository.save(product);

        ProductStock productStock = new ProductStock();
        productStock.setId(CommonUtils.generateUUID());
        productStock.setProduct(product);
        productStock.setQuantity("100");
        CommonUtils.setCreateEntityFields(productStock);
        CommonUtils.setUpdateEntityFields(productStock);
        productStockRepository.save(productStock);
    }
}
