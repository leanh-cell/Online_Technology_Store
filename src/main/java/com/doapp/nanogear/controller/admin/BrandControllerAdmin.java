package com.doapp.nanogear.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

import com.doapp.nanogear.entity.Brand;
import com.doapp.nanogear.service.BrandService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/admin")
@Controller
public class BrandControllerAdmin {
	
	@Autowired
	ServletContext app;
	
	@Autowired
	BrandService brandService;
	
	@GetMapping("/list-brand")
	public String listBrand(Model model, Optional<Integer> p, @RequestParam("keyword") Optional<String> key) {
		model.addAttribute("brand", brandService.findByBrandKeyWordAndPage(key,p));
		return "listbrand";
	}
	
	@GetMapping("/form-insert-brand")
	public String formInsert() {
		return "insertbrand";
	}
	
	@PostMapping("insert-brand")
	public String insertBrand(@RequestParam("image") MultipartFile image,Brand brand,Model model) {
		if(image.isEmpty()){
			System.out.println(image.getOriginalFilename());
			model.addAttribute("message", "Vui lòng chọn file !");
		}
		else{
			try {
				String filename = image.getOriginalFilename();
				File file = new File(app.getRealPath("/image/"+filename));
				image.transferTo(file);
				brand.setImg(image.getOriginalFilename());
				brandService.saveBrand(brand);
				model.addAttribute("message", "Thêm thành công");
				return "insertbrand";
			} 
			catch (Exception e) {
				model.addAttribute("brand", brand);
				model.addAttribute("message", "Lỗi lưu file !");
			}
		}
		return "insertbrand";
	}
	
	@GetMapping("/form-update-brand")
	public String formUpdate(@RequestParam("id") int idBrand,Model model) {
		model.addAttribute("brand", brandService.findById(idBrand));
		return "updatebrand";
	}
	
	@PostMapping("/update-brand")
	public String updateCatgory(Model model, @RequestParam("image") MultipartFile image, Brand brand) {
		if(image.isEmpty()) {
			brandService.saveBrand(brand);
			model.addAttribute("message", "Update thành công");
			model.addAttribute("brand",brand);
		}else {
			try {
				String filename = image.getOriginalFilename();
				File file = new File(app.getRealPath("/image/"+filename));
				image.transferTo(file);
				brand.setImg(image.getOriginalFilename());
				brandService.saveBrand(brand);
				model.addAttribute("message", "Update thành công");
				model.addAttribute("brand",brand);
				return "insertcategory";
			} 
			catch (Exception e) {
				model.addAttribute("brand", brand);
				model.addAttribute("message", "Lỗi lưu file !");
			}
		}
		return "updatebrand";
	}
	@GetMapping("delete-brand")
	public String deleteBrand(@RequestParam("id") int idBrand, RedirectAttributes model) throws IOException {
		Brand brand = brandService.findById(idBrand);
		Path path = Paths.get("src/main/webapp/image/" + brand.getImg());
		Files.delete(path);
		brandService.deleteBrandById(idBrand);
		model.addFlashAttribute("success","Đã xoá thương hiệu"+ brand.getName());
		return "redirect:/admin/list-brand";
	}
}
