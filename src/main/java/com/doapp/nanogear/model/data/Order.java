package com.doapp.nanogear.model.data;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "contact_user")
    private ContactUser contactUser;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @Column(name = "orderDate")
    private Date orderDate;

    @Column(name = "totalAmount")
    private double totalAmount;

    @Column(name = "totalPrice")
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "order_detail_id")
    private OrderDetail orderDetail;

    // Getters and setters
}