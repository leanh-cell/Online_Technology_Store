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

    @OneToOne
    @JoinColumn(name = "contact_user")
    private ContactUser contactUser;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @Column(name = "orderDate")
    private Date orderDate;

    @Column(name = "total_pay")
    private double tongthanhtoan;

    @Column(name = "total_cost")
    private String tongchiphi;

    @Column(name = "transport_fee")
    private String phivanchuyen;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "date_receipt")
    private Date deliveryDate;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "order_code")
    private String orderCode;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_status")
    private String paymentStatus;

    // Getters and setters

    public User getUser() {
        return user;
    }

    public ContactUser getContactUser() {
        return contactUser;
    }

    public void setContactUser(ContactUser contactUser) {
        this.contactUser = contactUser;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTongthanhtoan() {
        return tongthanhtoan;
    }

    public void setTongthanhtoan(double tongthanhtoan) {
        this.tongthanhtoan = tongthanhtoan;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getTongchiphi() {
        return tongchiphi;
    }

    public void setTongchiphi(String tongchiphi) {
        this.tongchiphi = tongchiphi;
    }

    public String getPhivanchuyen() {
        return phivanchuyen;
    }

    public void setPhivanchuyen(String phivanchuyen) {
        this.phivanchuyen = phivanchuyen;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}