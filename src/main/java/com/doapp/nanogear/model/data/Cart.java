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

    @ManyToMany(mappedBy = "carts")
    private List<Product> product;

    @Column(name = "quantity")
    public Integer quantity;

    public List<Product> getProduct() {
        return product;
    }

    public User getUser() {
        return user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
