package com.doapp.nanogear.model.data;


import javax.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products") // Xác định tên bảng là "products"
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double Price;

    @Column(name = "image_url") // Thêm cột cho trường ảnh
    private String imageUrl;

    @CreatedDate // Tạo giá trị tự động cho cột created_date
    @Column(name = "created_date") // Xác định tên cột trong bảng
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "product_detail")
    private ProductDetail productDetail;

    @ManyToOne
    @JoinColumn(name = "order_detail")
    private OrderDetail orderDetail;

    @ManyToMany(mappedBy = "products")
    private List<Category> categories;
}
