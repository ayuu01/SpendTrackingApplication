package com.example.SpendTrackingApplication.controller;

import com.example.SpendTrackingApplication.business.ProductService;
import com.example.SpendTrackingApplication.dao.ProductRepository;
import com.example.SpendTrackingApplication.entity.Product;
import com.example.SpendTrackingApplication.request.ProductRequest;
import com.example.SpendTrackingApplication.response.ProductResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/products/{category}")
    public List<ProductResponse> viewProductsAccToCategory(@PathVariable String category){
        List<ProductResponse> list=productService.viewProductsAccToCategory(category);
        return list;
    }
}