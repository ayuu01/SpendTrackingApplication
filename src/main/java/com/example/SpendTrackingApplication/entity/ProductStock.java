package com.example.SpendTrackingApplication.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_stock")
public class ProductStock extends ParentEntity {

    @Id
    private String id;
    private String quantity;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}