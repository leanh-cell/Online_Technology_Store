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

    @ManyToMany(mappedBy = "cat_id")
    private List<Product> products;

    // Getters and setters
}
