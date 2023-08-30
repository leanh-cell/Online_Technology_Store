package com.doapp.nanogear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/home")
    public String adminHome(){
            return "/admin/index";
    }
    @GetMapping("/access-denied")
    public String accessdenied(){
       return "admin/access-denied";

    }
}
