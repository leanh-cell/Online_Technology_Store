package com.doapp.nanogear.model.data;

import javax.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Table(name = "category")
public class Category {
    @Id
    private Integer id;
    @Column(name = "name")
    public String name;
    @OneToOne
    @JoinColumn(name = "id")
    private Product product;
    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
