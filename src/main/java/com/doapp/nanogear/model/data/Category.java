package com.doapp.nanogear.model.data;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "Products_Category",
            joinColumns = @JoinColumn(name = "Category_product_id"),
            inverseJoinColumns = @JoinColumn(name = "Products_id")
    )
    private List<Product> products;
}
