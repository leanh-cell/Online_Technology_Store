package com.doapp.nanogear.controller.admin;

import java.io.File;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.doapp.nanogear.entity.Product;
import com.doapp.nanogear.service.BrandService;
import com.doapp.nanogear.service.CategoryService;
import com.doapp.nanogear.service.ProductService;

@RequestMapping("/admin")
@Controller
public class ProductControllerAdmin {
	
	@Autowired
	ServletContext app;
	
	@Autowired
	BrandService brandService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/list-product")
	public String listProduct(Model model, Optional<Integer> p, @RequestParam("keyword") Optional<String> key) {
		model.addAttribute("listProduct",productService.getAllProductShare(key, p));
		return "listproduct";
	}
	
	@GetMapping("/form-product-insert")
	public String doGetInsertProduct(Model model) {
		model.addAttribute("listcbobrand", brandService.findAllBrand());
		model.addAttribute("listcbocategory", categoryService.getAllCategory());
		return "productinsert";
	}
	
	
	@GetMapping("/edit-product")
	public String doGetEditProduct(@RequestParam("id") String idProduct,Model model) {
		model.addAttribute("listcbobrand", brandService.findAllBrand());
		model.addAttribute("listcbocategory", categoryService.getAllCategory());
		model.addAttribute("formProduct",productService.findById(idProduct));
		return"formproductupdate";
	}
	
	@GetMapping("/form-product")
	public String getFormProduct(Model model) {
		model.addAttribute("listcbobrand", brandService.findAllBrand());
		model.addAttribute("listcbocategory", categoryService.getAllCategory());
		return "formproduct";
	}
	
	@PostMapping("/save-product")
	public String saveProduct(Model model,@RequestParam("image") MultipartFile image, Product product) {
		
		if(image.isEmpty()){
			System.out.println(image.getOriginalFilename());
			model.addAttribute("message", "Vui lòng chọn file !");
			model.addAttribute("listcbobrand", brandService.findAllBrand());
			model.addAttribute("listcbocategory", categoryService.getAllCategory());
			model.addAttribute("formProduct", product);
		}
		else{
			try {
				String filename = image.getOriginalFilename();
				File file = new File(app.getRealPath("/image/"+filename));
				image.transferTo(file);
				product.setImg(image.getOriginalFilename());
				product.getBrand().setId(product.getBrand().getId());
				product.getCategory().setId(product.getCategory().getId());
				productService.saveProduct(product);
				model.addAttribute("listcbobrand", brandService.findAllBrand());
				model.addAttribute("listcbocategory", categoryService.getAllCategory());
				model.addAttribute("formProduct", product);
				model.addAttribute("message", "Thêm sản phẩm thành công");
				return "productinsert";
			} 
			catch (Exception e) {
				model.addAttribute("message", "Lỗi lưu file !");
				model.addAttribute("listcbobrand", brandService.findAllBrand());
				model.addAttribute("listcbocategory", categoryService.getAllCategory());
				model.addAttribute("formProduct", product);
			}
		}
		model.addAttribute("listcbobrand", brandService.findAllBrand());
		model.addAttribute("listcbocategory", categoryService.getAllCategory());
		model.addAttribute("formProduct", product);
		return "productinsert";
	}
	
	@PostMapping("/update-Product")
	public String doPostUpdateProduct(Model model,@RequestParam("image") MultipartFile image, Product product) {
		if(image.isEmpty()) {
			productService.saveProduct(product);
			model.addAttribute("message", "Update thành công.");
			model.addAttribute("formProduct",product);
		}else {
			try {
				String filename = image.getOriginalFilename();
				File file = new File(app.getRealPath("/image/"+filename));
				image.transferTo(file);

				product.setImg(image.getOriginalFilename());
				product.getBrand().setId(product.getBrand().getId());
				product.getCategory().setId(product.getCategory().getId());
				productService.saveProduct(product);
				model.addAttribute("formProduct",product);
				return "formproductupdate";
			} 
			catch (Exception e) {
				model.addAttribute("formProduct",product);
				model.addAttribute("message", "Lỗi lưu file !");
			}
		}
		return "formproductupdate";
	}
}


