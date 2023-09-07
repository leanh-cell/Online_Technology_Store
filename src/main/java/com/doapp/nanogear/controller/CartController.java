package com.doapp.nanogear.controller;

import com.doapp.nanogear.model.data.Product;
import com.doapp.nanogear.model.data.User;
import com.doapp.nanogear.security.CartService;
import com.doapp.nanogear.security.OrderService;
import com.doapp.nanogear.security.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
@RequestMapping("/cart")
public class CartController {
    public final OrderService orderService;
    public final CartService cartService;
    public final ProductService productService;

    public CartController(OrderService orderService, CartService cartService, ProductService productService) {
        this.orderService = orderService;
        this.cartService = cartService;
        this.productService = productService;
    }

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

    String randomMaTracking() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = 5;
        Random random = new Random();

        String code;
        do {
            StringBuilder codeBuilder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characters.length());
                char randomChar = characters.charAt(index);
                codeBuilder.append(randomChar);
            }
            code = codeBuilder.toString();
        } while (trackingCodeExists(code)); // Kiểm tra nếu mã đã tồn tại
        return code;
    }

    boolean trackingCodeExists(String code) {
        return orderService.orderExistsWithCode(code);
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam("idProduct") int productId, HttpSession httpSession, Model model){
        if (!isAuthenticatedAndHasRole(httpSession,"USER")){
            User loggedInUser = (User) httpSession.getAttribute("loggedInUser");
            Product product = productService.findById(productId);
            cartService.addToCart(loggedInUser,productId);
            return "redirect:/myCart";
        }else{
            model.addAttribute("error","Please log in before adding products to cart !");
            return "redirect:/login";
        }

    }
}
