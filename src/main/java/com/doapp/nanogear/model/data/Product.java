package com.doapp.nanogear.model.data;


import javax.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double price;

    @Column(name = "image_url")
    private String imageUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @OneToOne
    @JoinColumn(name = "product_detail")
    private ProductDetail productDetail;

    @ManyToOne
    @JoinColumn(name = "order_detail")
    private OrderDetail orderDetail;

    @ManyToMany(mappedBy = "products")
    private List<Category> categories;
}