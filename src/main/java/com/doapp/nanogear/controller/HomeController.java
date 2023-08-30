package com.doapp.nanogear.controller;

import com.doapp.nanogear.model.data.Users;
import com.doapp.nanogear.security.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {
    private final UserService userService;
    public HomeController(UserService userService) {
        this.userService = userService;
        home();
    }

    @GetMapping("/home")
    public String home() {
            return "/form/index";
    }
    @GetMapping("/laptop-re")
    public String laptopRe() {

        return "form/laptop-re";
    }

    @GetMapping ("/login")
    public String login(Model model) {
        Users users = new Users();
        model.addAttribute("users", users);
        return "/form/login";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);
        return "form/register";
    }

}
