package com.example.SpendTrackingApplication.business;

import com.example.SpendTrackingApplication.dao.ProductRepository;
import com.example.SpendTrackingApplication.dao.ProductStockRepository;
import com.example.SpendTrackingApplication.entity.Product;
import com.example.SpendTrackingApplication.entity.ProductStock;
import com.example.SpendTrackingApplication.entity.User;
import com.example.SpendTrackingApplication.request.ProductRequest;
import com.example.SpendTrackingApplication.response.ProductResponse;
import com.example.SpendTrackingApplication.utils.CommonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductStockRepository productStockRepository;

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

    public List<ProductResponse> viewProductsAccToCategory(String category) {
        List<ProductResponse> list= new ArrayList<>();
        List<Product> response= (List<Product>) productRepository.viewProductsAccToCategory(category);
        response.forEach(element -> {
            ProductResponse productResponse= new ProductResponse();
            BeanUtils.copyProperties(element, productResponse);
            list.add(productResponse);
        });
        return list;
    }

    public void updateProduct(ProductRequest productRequest, String id) throws javax.xml.bind.ValidationException {
        Optional<Product> product = productRepository.findById(id);
        Product product1 = product.get();
        if (!product.isPresent()) {
            throw new javax.xml.bind.ValidationException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "product does not exists for id::" + id);
        }
        if (!(product1.getName().equals(productRequest.getName()))) {
            product1.setName(productRequest.getName());
        }
        if (!(product1.getCategory().equals(productRequest.getCategory()))) {
            product1.setCategory(productRequest.getCategory());
        }
        if (!(product1.getDescription().equals(productRequest.getDescription()))) {
            product1.setDescription(productRequest.getDescription());
        }
        if (!(product1.getPrice().equals(productRequest.getPrice()))) {
            product1.setPrice(productRequest.getPrice());
        }
        productRepository.save(product1);
    }
    public void deleteProductsStock(String id)  {
        productStockRepository.deleteById(id);

    }

    public void deleteProducts(String id)  {
        productRepository.deleteById(id);
        /*Optional<Product> product = Optional.ofNullable(productRepository.getProductByName(name));
        Product productDetails = product.get();
        if (product.isPresent()) {
            productRepository.deleteProductByName(productDetails.getName());
        }
        else {
                throw new ValidationException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "product does not exists for name::" + name);
        }*/
    }
}
