package com.doapp.nanogear.controller;

import com.doapp.nanogear.model.DTO.AuthenticatedHasRoleDTO;
import com.doapp.nanogear.model.data.Product;
import com.doapp.nanogear.model.data.User;
import com.doapp.nanogear.security.CartService;
import com.doapp.nanogear.security.OrderService;
import com.doapp.nanogear.security.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

    public AuthenticatedHasRoleDTO authenticatedHasRoleDTO;

    public CartController(OrderService orderService, CartService cartService, ProductService productService) {
        this.orderService = orderService;
        this.cartService = cartService;
        this.productService = productService;
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam("idProduct") int productId, HttpSession httpSession, Model model){
        if (!authenticatedHasRoleDTO.isAuthenticatedAndHasRole(httpSession,"USER")){
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
