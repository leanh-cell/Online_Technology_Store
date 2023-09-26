package com.doapp.nanogear.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.doapp.nanogear.service.CartService;
import com.doapp.nanogear.service.CategoryService;
import com.doapp.nanogear.service.OrderDetailService;
import com.doapp.nanogear.service.ProductService;


//@RequestMapping("/index")
@Controller
public class HomeController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@GetMapping("/home")
	public String Home(Model model) {
		model.addAttribute("listProductTop10", orderDetailService.findAllProductTop10());
		model.addAttribute("listProduct", productService.getAllProduct());
		model.addAttribute("listCategory", categoryService.getAllCategory());
		model.addAttribute("countCart",cartService.countCart());
		return "homePage";
	}
	
	@GetMapping("/listcategory")
	public String listCategory() {
		return "listCategory";
	}
	
	@GetMapping("/testuser")
	public String test() {
		return "user_order";
	}
}
