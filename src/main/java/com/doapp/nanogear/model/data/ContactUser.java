package com.doapp.nanogear.model.data;

import javax.persistence.*;


@Entity
@Table(name = "contact_user")
public class ContactUser {
    @Id
    private Integer id;

    @Column(name = "image_url")
    public String image_url;

    @Column(name = "city")
    private String city;

    @Column(name = "province")
    private String province;

    @Column(name = "town")
    private String town;

    @Column(name = "street")
    private String street;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "totalOrder")
    private Integer totalOrder;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters and setters

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getTotalOrder() {
        return totalOrder;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setTotalOrder(Integer totalOrder) {
        this.totalOrder = totalOrder;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}