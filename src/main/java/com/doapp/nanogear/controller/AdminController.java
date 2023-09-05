package com.doapp.nanogear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private boolean isAuthenticatedAndHasRole(HttpSession session, String requiredRole) {
        // Kiểm tra xem người dùng đã đăng nhập hay chưa
        if (session.getAttribute("loggedInUser") == null) {
            return false;
        }
        // Lấy thông tin về vai trò từ session hoặc cơ sở dữ liệu
        String userRole = (String) session.getAttribute("userRole"); // "userRole" thuộc tính chứa vai trò trong session
        // Kiểm tra vai trò của người dùng
        return userRole != null && userRole.equals(requiredRole);
    }

    @RequestMapping("/home")
    public String adminHome(HttpSession session) {
        if (!isAuthenticatedAndHasRole(session, "ADMIN")) {
            return "/admin/index";
        }
        return "redirect:/home";
    }

    @GetMapping("/access-denied")
    public String accessdenied() {
        return "admin/access-denied";
    }
}
