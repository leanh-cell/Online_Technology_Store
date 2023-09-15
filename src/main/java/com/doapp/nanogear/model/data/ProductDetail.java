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
    private Product product;
    // Getters and setters

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public Double getInch() {
        return inch;
    }

    public void setInch(Double inch) {
        this.inch = inch;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
