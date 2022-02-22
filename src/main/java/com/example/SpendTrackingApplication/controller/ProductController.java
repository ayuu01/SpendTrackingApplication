package com.example.SpendTrackingApplication.controller;

import com.example.SpendTrackingApplication.business.ProductService;
import com.example.SpendTrackingApplication.dao.ProductRepository;
import com.example.SpendTrackingApplication.entity.Product;
import com.example.SpendTrackingApplication.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/product")
    public void add(@RequestBody ProductRequest productRequest) {
        productService.product(productRequest);
    }

    @GetMapping("/product")
    public List<Product> getAll() {
        List<Product> list = (List<Product>) productRepository.findAll();
        return list;
    }
}