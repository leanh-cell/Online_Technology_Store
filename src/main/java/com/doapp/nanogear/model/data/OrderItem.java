package com.doapp.nanogear.model.data;

import javax.persistence.*;

@Entity
@Table(name = "orders_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;
}
