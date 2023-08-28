package com.doapp.nanogear.controller;

import com.doapp.nanogear.model.data.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/index")
    public String home() {
        return "form/index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        Users users = new Users();
        model.addAttribute("users", users);
        return "/form/login";
    }


}
