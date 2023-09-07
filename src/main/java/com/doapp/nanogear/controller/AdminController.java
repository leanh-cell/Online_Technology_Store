package com.doapp.nanogear.controller;


import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/home")
    public String home(){
        return "/admin/index";
    }
    @GetMapping("/add_product")
    public String AddProduct(){
        return "/admin/add_product";
    }
    @GetMapping("/product_list")
    public String ProductList(){
        return "/admin/product_list";
    }

    @GetMapping("/add_category")
    public String AddCategory(){
        return "/admin/add_category";
    }
    @GetMapping("/category_list")
    public String CategoryList(){
        return "/admin/category_list";
    }
}


