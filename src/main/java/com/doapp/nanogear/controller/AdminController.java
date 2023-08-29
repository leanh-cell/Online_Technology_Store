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
}


