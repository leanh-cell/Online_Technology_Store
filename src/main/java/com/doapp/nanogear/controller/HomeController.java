package com.doapp.nanogear.controller;

import com.doapp.nanogear.model.data.Users;
import com.doapp.nanogear.security.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/home")
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String home() {
        return "form/inden";
    }

    @GetMapping("/login_page")
    public String login(){
        return "/form/index";
    }
//    public String loginView(Model model){
//        Users user = new Users();
//        model.addAttribute("user", user);
//        return "/form/inden";
//    }

    public enum UserRole {
        USER("USER"),ADMIN("ADMIN");
        private final String value;

        UserRole(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

//    @PostMapping("/login")
//    public String loginUser(@ModelAttribute("user") Users user,Model model, HttpSession session) {
//
//        // Xác thực người dùng và lấy thông tin từ cơ sở dữ liệu
//        Users authenticatedUser = userService.authenticateUser(user.getUsername(), user.getPassword());
//        if (authenticatedUser != null) {
//            session.setAttribute("loggedInUser", authenticatedUser);
//            // Lưu thông tin người dùng vào phiên làm việc
//            session.setAttribute("loggedInUser", authenticatedUser);
//            String userRoleValue = authenticatedUser.getRole(); // "admin", "user"
//            UserRole userRole = UserRole.valueOf(userRoleValue.toUpperCase());
//
//            System.out.println(session + "/ " + authenticatedUser.username + "/ " + authenticatedUser.id + " /" + userRole + " /");
//            if (userRole == UserRole.ADMIN) {
//                return "redirect:/admin/index";
//            } else if (userRole == UserRole.USER) {
//                return "redirect:/home/index";
//            }
//        } else {
//            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng.");
//            return "/form/login-form";
//        }
//        return null;
//    }
}
