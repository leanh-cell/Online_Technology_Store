package com.doapp.nanogear.model.data;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "cart")
public class Cart {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    public Integer quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
