package com.doapp.nanogear.controller;

import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import com.doapp.nanogear.entity.DeliveryAddress;
import com.doapp.nanogear.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.doapp.nanogear.been.CookieService;
import com.doapp.nanogear.been.ParamService;

import com.doapp.nanogear.been.SessionService;
import com.doapp.nanogear.entity.User;

@Controller
public class UserController {

    @Autowired
    CookieService cookieService;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    SendEmailService sendEmailService;

    @Autowired
    DeliveryAddressService deliveryService;

    @Autowired
    CartService cartService;

    @GetMapping("/formlogin")
    public String formLogin(Model model) {
        model.addAttribute("u", cookieService.getValue("user", ""));
        model.addAttribute("p", cookieService.getValue("pass", ""));
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model) {
        String un = paramService.getString("username", "");
        String pw = paramService.getString("password", "");
        boolean rmb = paramService.getBoolean("remember", false);
        if (userService.findByIdAndPassword(un, pw) == null) {
            cookieService.remove("user");
            cookieService.remove("pass");
//			model.addAttribute(pw);
            model.addAttribute("login", "Sai tài khoản hoặc mật khẩu.");
            return "login";
        } else {
            User user = userService.findByIdAndPassword(un, pw);
            sessionService.setAttribute("logintc", "Đăng nhập thành công.");
            sessionService.setAttribute("userss", user);
            String userId = user.getId();

            if (rmb = true) {
                cookieService.add("user", un, 10);
                cookieService.add("pass", pw, 10);
            }
            return "redirect:/home";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        sessionService.removeAttribute("userss");
        cartService.deleteAllProduct();
        return "redirect:/home";
    }

    @GetMapping("/userinfo")
    public String userInfo(Model model) {
//		model.addAttribute("countCart", cartService.countCart());
        return "user_information";
    }

    @GetMapping("/edituser")
    public String editUser(@ModelAttribute("user") User user) {
        return "edituser";
    }

    @PostMapping("/saveuser")
    public String saveUser(@ModelAttribute("user") User u, @RequestParam("id") String idUser) {
        User user = userService.findById(idUser);
        user.setName(u.getName());
        user.setAddress(u.getAddress());
        user.setEmail(u.getEmail());
        user.setPhone(u.getPhone());
        userService.saveUser(user);
        sessionService.setAttribute("messageUserUpdate", "Cập nhật thông tin thành công.");
        sessionService.setAttribute("userss", user);
        return "redirect:/userinfo";
    }

    @GetMapping("/formregister")
    public String formRegister(User user) {
        return "register";
    }

    @PostMapping("/registersave")
    public String registerSave(User u, Model model) {
        User idUser = userService.findIdUserById(u.getId());
        if (!isValidPassword(u.getPassword())) {
            model.addAttribute("messageUserRegister", "Mật khẩu phải dài trên 6 ký tự và phải bao gồm cả chữ và số .");
            return "register";
        }
        System.out.println("iD: " + u.getId());
        if (idUser == null) {
            String pass = encodePassword(u.getPassword());
            String token = UUID.randomUUID().toString();
            if (userService.findUserByToken(token) != null) {
                String tokenNew = UUID.randomUUID().toString();
                u.setPassword(pass);
                u.setCode(tokenNew);
                u.setRole(false);
                u.setActive(false);
                userService.saveUser(u);
                sessionService.setAttribute("register", "Đăng kí tài khoản thành công và bạn sẽ được chuyển hướng đến trang login sau khi thông báo kết thúc !");
            }
            u.setPassword(pass);
            u.setCode(token);
            u.setRole(false);
            u.setActive(false);
            userService.saveUser(u);
            sessionService.setAttribute("register", "Đăng kí tài khoản thành công và bạn sẽ được chuyển hướng đến trang login sau khi thông báo kết thúc !");

        } else {
            model.addAttribute("messageUserRegister", "Username đã tồn tại. Vui lòng chọn username khác.");
        }
        return "register";
    }

    private String encodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 6 && containsDigit(password) && containsLetter(password);
    }

    private boolean containsDigit(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsLetter(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    @GetMapping("/user-order")
    public String userInformation(Model model) {
        User userSession = sessionService.get("userss");
        if (userSession == null) {
            return "redirect:/formlogin";
        } else {
            model.addAttribute("informationOrder", orderService.findByOrderUserId(userSession.getId()));
            return "user_order";
        }
    }

    @GetMapping("/user-order-details")
    public String userOrderDetails(Model model, @RequestParam("idorder") long idOrder) {
        model.addAttribute("detailOrder", orderDetailService.findByOrderDetailIdOrder(idOrder));
        model.addAttribute("Order", orderService.findOrderById(idOrder));
        return "user_order_detail";
    }

    @GetMapping("/user-delivery-address")
    public String userDeliveryAddress(Model model) {
        User userSession = sessionService.get("userss");
        if (userSession == null) {
            return "redirect:/formlogin";
        } else {
            List<DeliveryAddress> deliveryAddress = deliveryService.findByIdUser(userSession.getId());
            if (deliveryAddress != null) {
                List<DeliveryAddress> sortedDeliveryAddress = deliveryAddress.stream()
                        .sorted(Comparator.comparingInt(address -> address.getIsUse() == 0 ? 0 : 1))
                        .collect(Collectors.toList());
                model.addAttribute("deliveryAddress", sortedDeliveryAddress);
                return "user_delivery_address";
            }
            model.addAttribute("notfound", "Chưa có địa chỉ nào được thêm,vui lòng thêm địa chỉ mới để xem chi tiết");
            return "user_delivery_address";
        }
    }

    @GetMapping("/form-forgotpassword")
    public String formForgotPassword() {

        return "forgotpassword";
    }

    @PostMapping("/check-forgot")
    public String checkForgot(Model model) throws UnsupportedEncodingException, MessagingException {
        String username = paramService.getString("username", "");
        String email = paramService.getString("email", "");
        System.out.println("Username: " + username);
        User user = userService.findByUserForgotPass(username);
        if (user == null) {
            model.addAttribute("message", "Tài khoản không tồn tại.");
            model.addAttribute("username", username);
            model.addAttribute("email", email);
            return "forgotpassword";
        } else if (!user.getEmail().equals(email)) {
            model.addAttribute("message", "Email không đúng với tài khoản.");
            model.addAttribute("username", username);
            model.addAttribute("email", email);
            return "forgotpassword";
        } else {
            sendEmailService.sendEmail(email, username);
            model.addAttribute("message", "Gửi mail thành công. Vui lòng kiếm tra hòm thư gmail của bạn.");
            return "forgotpassword";
        }
    }

    @GetMapping("/form-resetpassword")
    public String forgotPass(Model model) {
        String token = paramService.getString("token", "");
        User user = userService.findUserByToken(token);
        if (user == null) {
            return "redirect:/home";
        } else {
            if (user.getCode().equals(token) && user.isActive() == true) {
                model.addAttribute("token", token);
                return "forgotpassword2";
            } else {
                return "redirect:/home";
            }
        }
    }

    @PostMapping("/save-resetpassword")
    public String saveResetPassword(Model model) {
        String token = paramService.getString("token", "");
        String password = paramService.getString("password", "");
        String password2 = paramService.getString("password2", "");
        User user = userService.findUserByToken(token);
        if (user == null || user.isActive() == false) {
            return "redirect:/home";
        } else {
            if (!password.equals(password2)) {
                model.addAttribute("message", "Mật khẩu không khớp.");
                model.addAttribute("password", password);
                model.addAttribute("token", token);
                return "forgotpassword2";
            } else {
                userService.saveResetPassword(token, password);
                model.addAttribute("message", "Đặt lại mật khẩu thành công.");
                model.addAttribute("token", "");
                return "redirect:/resetpasssucces";
            }
        }
    }

    @GetMapping("/resetpasssucces")
    public String resetPassSucces() {

        return "resetpasssucces";
    }

    @GetMapping("/noadmin")
    public String noAdmin() {

        return "noadmin";
    }

    @GetMapping("/form-change-pass")
    public String formChangePass(Model model) {
        return "changepassword";
    }

    @PostMapping("/save-change-pass")
    public String saveChangePass(Model model, @RequestParam("password") String password,
                                 @RequestParam("passwordnew") String passwordnew,
                                 @RequestParam("passwordnew2") String passwordnew2) {
        User userss = sessionService.get("userss");
        User user = userService.findIdUserById(userss.getId());
        if (!user.getPassword().equals(password)) {
            model.addAttribute("message", "Mật khẩu cũ k khớp");
        } else if (!passwordnew.equals(passwordnew2)) {
            model.addAttribute("password", password);
            model.addAttribute("passwordnew", passwordnew);
            model.addAttribute("message", "Mật mới không khớp");
        } else {
            String passnew = encodePassword(passwordnew);
            userss.setPassword(passnew);
            userService.saveUser(userss);
            model.addAttribute("message", "Đổi mật khẩu thành công.");
        }
        return "changepassword";
    }
}
