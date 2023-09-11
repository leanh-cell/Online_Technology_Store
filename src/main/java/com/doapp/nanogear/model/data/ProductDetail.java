package com.doapp.nanogear.model.data;

import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "product_detail")
public class ProductDetail {
    @Id
    private int id;

    @Column(name = "cpu")
    public String cpu;

    @Column(name = "ram")
    public Integer ram;
    @Column(name = "storage")
    public String storage;

    @Column(name = "gpu")
    public String gpu;
    @Column(name = "inch")
    public Double inch;

    @OneToOne
    @JoinColumn(name = "id")
    private Product product;
    // Getters and setters
}
