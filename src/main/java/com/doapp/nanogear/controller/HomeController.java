package com.doapp.nanogear.controller;

import com.doapp.nanogear.entity.Product;
import com.doapp.nanogear.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;


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

	@Autowired
	BannerService bannerService;

	
	@GetMapping("/home")
	public String Home(Model model) {
		model.addAttribute("listBanner", bannerService.getAll());
		model.addAttribute("listProductTop10",productService.findAllProductTop10());
		model.addAttribute("listProductDiscount",productService.findProductsWithDiscount());
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
