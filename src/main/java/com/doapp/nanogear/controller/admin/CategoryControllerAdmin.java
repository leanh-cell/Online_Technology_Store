package com.doapp.nanogear.controller.admin;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.doapp.nanogear.entity.Category;
import com.doapp.nanogear.service.CategoryService;
@RequestMapping("/admin")
@Controller
public class CategoryControllerAdmin {
	
	@Autowired
	ServletContext app;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/list-category")
	public String formCategory(Model model) {
		model.addAttribute("category", categoryService.getAllCategory());
		return"listcategory";
	}
	
	@GetMapping("/form-insert-category")
	public String editCategory() {
		return "insertcategory";
	}
	
	@PostMapping("/insert-category")
	public String saveCategory(@RequestParam("image") MultipartFile image,Category category,Model model) {
		if(image.isEmpty()){
			System.out.println(image.getOriginalFilename());
			model.addAttribute("message", "Vui lòng chọn file !");
			model.addAttribute("category", category);
		}
		else{
			try {
				String filename = image.getOriginalFilename();
				File file = new File(app.getRealPath("/image/"+filename));
				image.transferTo(file);
				category.setImg(image.getOriginalFilename());
				categoryService.saveCategory(category);
				model.addAttribute("message", "Thêm thành công");
				model.addAttribute("category", category);
				return "insertcategory";
			} 
			catch (Exception e) {
				model.addAttribute("category", category);
				model.addAttribute("message", "Lỗi lưu file !");
			}
		}
		return "insertcategory";
	}
	
	@GetMapping("/form-update-category")
	public String editCategory(Model model, @RequestParam("id") int id) {
		model.addAttribute("category", categoryService.findById(id));
		return "update-category";
	}
	
	@PostMapping("/update-category")
	public String updateCatgory(Model model, @RequestParam("image") MultipartFile image, Category category) {
		if(image.isEmpty()) {
			categoryService.saveCategory(category);
			model.addAttribute("message", "Update thành công");
		}else {
			try {
				String filename = image.getOriginalFilename();
				File file = new File(app.getRealPath("/image/"+filename));
				image.transferTo(file);
				category.setImg(image.getOriginalFilename());
				categoryService.saveCategory(category);
				model.addAttribute("message", "Update thành công");
				model.addAttribute("category", category);
			} 
			catch (Exception e) {
				model.addAttribute("category", category);
				model.addAttribute("message", "Lỗi lưu file !");
			}
		}
		return "update-category";
	}
}
