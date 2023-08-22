package com.doapp.nanogear.model.data;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Orders") // Xác định tên bảng là "Orders"
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserID") // Ánh xạ khóa ngoại đến bảng "Users"
    private Users user;

    @Column(name = "OrderDate")
    private java.sql.Date orderDate;

    @Column(name = "TotalAmount")
    private double totalAmount;

    @Column(name = "TotalPrice")
    private double totalPrice;

    @Column(name = "OrderStatus")
    private String orderStatus;
}