package com.example.SpendTrackingApplication.controller;

import com.example.SpendTrackingApplication.business.ProductService;
import com.example.SpendTrackingApplication.business.PurchaseService;
import com.example.SpendTrackingApplication.business.UserService;
import com.example.SpendTrackingApplication.dao.ProductRepository;
import com.example.SpendTrackingApplication.entity.Product;
import com.example.SpendTrackingApplication.model.Purchase;
import com.example.SpendTrackingApplication.request.ProductRequest;
import com.example.SpendTrackingApplication.response.ProductResponse;
import com.example.SpendTrackingApplication.response.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/products")
    public void addProduct(@RequestBody ProductRequest productRequest) {
        productService.product(productRequest);
    }

    @GetMapping("/admin/products")
    public List<ProductResponse> getProducts(){
        List<ProductResponse> list= new ArrayList<>();
        List<Product> response= (List<Product>) productRepository.findAll();
        response.forEach(element -> {
            ProductResponse productResponse= new ProductResponse();
            BeanUtils.copyProperties(element, productResponse);
            list.add(productResponse);
        });
        return list;
    }

    @PutMapping("/update/product/{id}")
    public void updateProduct(@RequestBody ProductRequest productRequest ,@PathVariable("id") String id) throws ValidationException {
        productService.updateProduct(productRequest,id);
    }

    @DeleteMapping("/deleteproductinstock/{id}")
    public void deleteStockProducts(@PathVariable String id)  {
        productService.deleteProductsStock(id);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public void deleteProducts(@PathVariable String id)  {
      productService.deleteProducts(id);
    }

    @GetMapping("/admin/getUsers")
    public List<UserResponse> getAllUsers(){
        List<UserResponse> list=userService.getUsers();
        return list;
    }

    @GetMapping("/allPurchases")
    public List<Purchase> getAllPurchases(){
        /*List<Purchase> response = new ArrayList<>();
        Document query = new Document();
        Document projection = new Document();
        projection.put(_ID, 0);
        List<Document> result = purchaseRepository.findList(Purchase, query, projection);*/
        List<Purchase> list= purchaseService.getAllPurchases();
        return list;
    }
}
