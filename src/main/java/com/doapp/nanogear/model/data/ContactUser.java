package com.doapp.nanogear.model.data;

import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name = "contact_user") // Xác định tên bảng là "contact_user"
@Data
public class ContactUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;

    private String province;

    private String town;

    private String street;

    @Column(name = "image_url") // Thêm cột cho trường ảnh
    private String imageUrl;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "user_id") // Ánh xạ khóa ngoại đến bảng "users"
    private Users user;
}
