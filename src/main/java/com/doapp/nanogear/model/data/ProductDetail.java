package com.doapp.nanogear.model.data;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_detail") // Xác định tên bảng là "product_detail"
@Data
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cpu;

    private int ram;

    private String storage;

    private String gpu;

    private double inch;

    @OneToOne(mappedBy = "productDetail") // Ánh xạ ngược từ khóa ngoại ở Product
    private Product product;
}
