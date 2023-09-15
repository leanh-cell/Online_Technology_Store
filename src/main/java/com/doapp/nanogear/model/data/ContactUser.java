package com.doapp.nanogear.model.data;

import javax.persistence.*;


@Entity
@Table(name = "contact_user")
public class ContactUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "full_name")
    public String fullName;

    @Column(name = "image_url")
    public String image_url;

    @Column(name = "city")
    public String city;

    @Column(name = "province")
    public String province;

    @Column(name = "town")
    public String town;

    @Column(name = "street")
    public String street;

    @Column(name = "phoneNumber")
    public String phoneNumber;

    @Column(name = "totalOrder")
    private Integer totalOrder;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }



    public Integer getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(Integer totalOrder) {
        this.totalOrder = totalOrder;
    }

}