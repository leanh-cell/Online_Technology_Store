package com.doapp.nanogear.model.data;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "Cart") // Xác định tên bảng là "Cart"
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id") // Ánh xạ khóa ngoại đến bảng "Users"
    private Users user;

    @ManyToOne
    @JoinColumn(name = "product_id") // Ánh xạ khóa ngoại đến bảng "Products"
    private Product product;

    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
