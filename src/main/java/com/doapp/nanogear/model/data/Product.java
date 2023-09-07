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
    private Integer cat_id;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private ProductDetail productDetailId;

    @ManyToMany
    @JoinTable(
            name = "products_cart",
            joinColumns = @JoinColumn(name = "products_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_product_id")
    )
    private List<Cart> carts;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @ManyToMany
    @JoinTable(
            name = "products_category",
            joinColumns = @JoinColumn(name = "products_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    // Getters and setters
}