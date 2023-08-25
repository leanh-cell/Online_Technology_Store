package com.doapp.nanogear.model.data;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
@Entity
@Table(name = "Users") // Xác định tên bảng là "Users"
@Data
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Size(min = 2, message = "Username must be at least 2 characters long")
    public String username;

    @Size(min = 4, message = "Password must be at least 2 characters long")
    public String password;

    @Transient
    public String confirmPassword;

    @Email(message = "Please enter a valid email")
    public String email;

    @Column(name = "phone_number")
    @Size(min = 6, message = "Phone number must be at least 6 characters long")
    public String phoneNumber;

    @Column(name = "role")
    public String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
