package com.doapp.nanogear.model.data;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "OrderDetails") // Xác định tên bảng là "OrderDetails"
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "OrderID") // Ánh xạ khóa ngoại đến bảng "Orders"
    private Order order;

    private int quantity;

    @Column(name = "TotalPrice")
    private double totalPrice;

    @Column(name = "delivery_date")
    private java.sql.Date deliveryDate;
}
