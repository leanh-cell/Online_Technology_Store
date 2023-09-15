package com.doapp.nanogear.model.data;


import javax.persistence.*;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private Integer id;
    private String name;
    private double price;
    private String description;
    private String imageUrl;
    private Timestamp createdDate;
    private Integer quantity;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @JoinColumn(name = "Product_detail_id")
    private ProductDetail productDetailId;

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    private Category category;
    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ProductDetail getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(ProductDetail productDetailId) {
        this.productDetailId = productDetailId;
    }
}