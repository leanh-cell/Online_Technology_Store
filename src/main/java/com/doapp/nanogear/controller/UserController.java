package com.doapp.nanogear.controller;

import com.doapp.nanogear.model.data.Users;
import com.doapp.nanogear.security.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    public enum UserRole {
        USER("USER"), ADMIN("ADMIN");
        private final String value;

        UserRole(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("users") Users users, Model model, HttpSession session) {
        // Xác thực người dùng và lấy thông tin từ cơ sở dữ liệu
        Users authenticatedUser = userService.authenticateUser(users.getUsername(), users.getPassword());
        if (authenticatedUser != null) {
//            if (authenticatedUser.username != users.username) {
//                return "sai tk dang nhap";
//            }
//            if (authenticatedUser.password != users.password) {
//                return "sai mk dang nhap";
//            }
//            if (authenticatedUser.username == users.username && authenticatedUser.password == users.password) {
                session.setAttribute("loggedInUser", authenticatedUser);
                // Lưu thông tin người dùng vào phiên làm việc
                session.setAttribute("loggedInUser", authenticatedUser);
                String userRoleValue = authenticatedUser.getRole(); // "admin", "user"
                UserRole userRole = UserRole.valueOf(userRoleValue.toUpperCase());
                System.out.println(session + "/ " + authenticatedUser.username + "/ " + authenticatedUser.id + " /" + userRole + " /");
                if (userRole == UserRole.ADMIN) {
                    return "redirect:/admin/home";
                } else if (userRole == UserRole.USER) {
                    return "redirect:/index";
                }
//            }
        } else {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng.");
            return "/form/index";
        }
        return null;
    }
}
