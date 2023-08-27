package com.doapp.nanogear.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/index")
    public String index(){
        return "admin/index";
    }
}
