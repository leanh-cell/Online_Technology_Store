package com.doapp.nanogear.model.data;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    private Integer id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "totalPrice")
    private double totalPrice;

    @Column(name = "deliveryDate")
    private Date deliveryDate;

    @Column(name = "orderStatus")
    private String orderStatus;

    @Column(name = "order_code")
    private String orderCode;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "orderDetail", cascade = CascadeType.ALL)
    private List<Order> orders;

    // Getters and setters
}
