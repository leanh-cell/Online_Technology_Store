package com.doapp.nanogear.model.data;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "orders") // Xác định tên bảng là "Orders"
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id") // Ánh xạ khóa ngoại đến bảng "Users"
    private Users user;

    @Column(name = "order_date")
    private java.sql.Date orderDate;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "order_status")
    private String orderStatus;
}