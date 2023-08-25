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
public class Users implements UserDetails {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 2, message = "Username must be at least 2 characters long")
    private String username;

    @Size(min = 4, message = "Password must be at least 2 characters long")
    private String password;

    @Transient
    private String confirmPassword;

    @Email(message = "Please enter a valid email")
    private String email;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
