package com.doapp.nanogear.controller;

import com.doapp.nanogear.model.DTO.AuthenticatedHasRoleDTO;
import com.doapp.nanogear.model.DTO.UserDTO;
import com.doapp.nanogear.model.data.Cart;
import com.doapp.nanogear.model.data.ContactUser;
import com.doapp.nanogear.model.data.User;
import com.doapp.nanogear.security.CartService;
import com.doapp.nanogear.security.ContactUserService;
import com.doapp.nanogear.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private ContactUserService contactUserService;

    public AuthenticatedHasRoleDTO authenticatedHasRoleDTO;



//    public UserController(UserService userService, CartService cartService, ContactUserService contactUserService) {
//        this.userService = userService;
//        this.cartService = cartService;
//        this.contactUserService = contactUserService;
//    }

//    private boolean isAuthenticatedAndHasRole(HttpSession session, String requiredRole) {
//        // Kiểm tra xem người dùng đã đăng nhập hay chưa
//        if (session.getAttribute("loggedInUser") == null) {
//            return false;
//        }
//        // Lấy thông tin về vai trò từ session hoặc cơ sở dữ liệu
//        String userRole = (String) session.getAttribute("userRole"); // "userRole" thuộc tính chứa vai trò trong session
//        // Kiểm tra vai trò của người dùng
//        return userRole != null && userRole.equals(requiredRole);
//    }

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
    public String loginUser(@RequestParam("usernameOrEmail") String usernameOrEmail, @RequestParam("password") String password, Model model, HttpSession session) {
        // Xác thực người dùng và lấy thông tin từ cơ sở dữ liệu
        User authenticatedUser = userService.authenticateUser(usernameOrEmail, password);

        if (authenticatedUser != null) {
            // Lưu thông tin người dùng vào phiên làm việc
            session.setAttribute("loggedInUser", authenticatedUser);
            session.setAttribute("userRole", authenticatedUser.role);

            String userRoleValue = authenticatedUser.getRole(); // "admin", "user"
            UserRole userRole = UserRole.valueOf(userRoleValue.toUpperCase());
            System.out.println(session + "/ " + authenticatedUser.username + "/ " + authenticatedUser.id + " /" + userRole + " /");

            List<Cart> cart = cartService.getCartsByUserId(authenticatedUser.id);
            ContactUser contactUser = contactUserService.getUserInfoByUserId(authenticatedUser.id);
            session.setAttribute("contact", contactUser);
            session.setAttribute("cart", cart);
            if (userRole == UserRole.ADMIN) {
                return "redirect:/admin/home";
            } else if (userRole == UserRole.USER) {
                return "redirect:/home";
            }
//            }
        } else {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng.");
            return "/form/index";
        }
        return null;
    }


    @PostMapping("/register")
    public String registerUser(@ModelAttribute("registrationDTO") UserDTO registrationDTO) {
        User user = registrationDTO.getUser();
        ContactUser contactUser = registrationDTO.getContactUser();
        // Kiểm tra xem người dùng đã tồn tại chưa
        if (userService.findByUsernameOrEmail(user.getUsername() != null ? user.getUsername() : user.getEmail()) != null) {
            // Xử lý lỗi: người dùng đã tồn tại
            return "redirect:/users/register?error";
        }

        // Mã hóa mật khẩu trước khi lưu vào đối tượng User
        String encodedPassword = encodePassword(user.getPassword());
        user.setRole("user");
        user.setPassword(encodedPassword);
        contactUser.setUser(user);
        // Lưu đối tượng User vào cơ sở dữ liệu
        userService.save(user);
        contactUserService.saveUserInfo(contactUser);

        return "redirect:/login";
    }

    private String encodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }


    @PostMapping("/inForUser/{username}")
    public String inforUser(@PathVariable("username") String username, @RequestParam("userid") int userid, HttpSession session, Model model) {
        if (!authenticatedHasRoleDTO.isAuthenticatedAndHasRole(session,"USER")) {
            User user = userService.getUserById(userid);
            ContactUser contactUser = contactUserService.getUserInfoByUserId(userid);
            model.addAttribute("user", user);
            model.addAttribute("contactUser", contactUser);
            return "redirect:/inForUser/{username}";
        }
        model.addAttribute("error", "Bạn chưa đăng nhập , vui lòng đăng nhập để có thể xem các thông tin chi tiết !");
        return "";
    }

    @PutMapping("/changePass")
    public String changePass(@RequestParam("newPass") String newPass, HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        if (!authenticatedHasRoleDTO.isAuthenticatedAndHasRole(session,"USER")) {
            User user = (User) session.getAttribute("loggedInUser");
            userService.changePassword(user, newPass);
            redirectAttributes.addFlashAttribute("message", "Change Password success!");
            return "redirect:/home";
        }
        return "redirect:/login";
    }

    @PutMapping("/update/{username}")
    public void updateUser(@PathVariable("username") String username,
                           @ModelAttribute("user") User updatedUser,
                           @ModelAttribute("contactUsers") ContactUser updatedContactUsers,
                           @RequestParam("multipartFile") MultipartFile file,
                           HttpSession session) {
        if (!authenticatedHasRoleDTO.isAuthenticatedAndHasRole(session,"USER")) {
            User user = (User) session.getAttribute("loggedInUser");
            userService.updateUserAndContactUser(user.id, updatedUser, updatedContactUsers, file);
        }
    }
}