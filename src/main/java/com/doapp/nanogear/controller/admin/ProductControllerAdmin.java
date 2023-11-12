package com.doapp.nanogear.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.doapp.nanogear.entity.Product;
import com.doapp.nanogear.service.BrandService;
import com.doapp.nanogear.service.CategoryService;
import com.doapp.nanogear.service.ProductService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/add-new-product")
	public String doGetInsertProduct(Model model) {
		model.addAttribute("listcbobrand", brandService.findAllBrand());
		model.addAttribute("listcbocategory", categoryService.getAllCategory());
		return "add_new_product";
	}
	
	
	@GetMapping("/edit-product")
	public String doGetEditProduct(@RequestParam("id") String idProduct,Model model) {
		model.addAttribute("listcbobrand", brandService.findAllBrand());
		model.addAttribute("listcbocategory", categoryService.getAllCategory());
		model.addAttribute("formProduct",productService.findById(idProduct));
		return"update_product";
	}
	
	@GetMapping("/form-product")
	public String getFormProduct(Model model) {
		model.addAttribute("listcbobrand", brandService.findAllBrand());
		model.addAttribute("listcbocategory", categoryService.getAllCategory());
		return "formproduct";
	}
	
	@PostMapping("/save-product")
	public String saveProduct(Model model, @RequestParam("image") List<MultipartFile> images, Product product) {
		
		if(images.isEmpty()){
//			System.out.println(image.getOriginalFilename());
			model.addAttribute("message", "Vui lòng chọn file !");
			model.addAttribute("listcbobrand", brandService.findAllBrand());
			model.addAttribute("listcbocategory", categoryService.getAllCategory());
			model.addAttribute("formProduct", product);
			return "redirect:/admin/add-new-product";
		}
		else{
			StringBuilder imageFileNames = new StringBuilder();
			try {
				for (MultipartFile image : images) {
					String filename = image.getOriginalFilename();
					File file = new File(app.getRealPath("/image/" + filename));
					image.transferTo(file);
					if (imageFileNames.length() > 0) {
						imageFileNames.append(",");
					}
					imageFileNames.append(filename);
				}
				product.setImg(imageFileNames.toString());
				product.getBrand().setId(product.getBrand().getId());
				product.getCategory().setId(product.getCategory().getId());
				productService.saveProduct(product);
				model.addAttribute("listcbobrand", brandService.findAllBrand());
				model.addAttribute("listcbocategory", categoryService.getAllCategory());
				model.addAttribute("formProduct", product);
				model.addAttribute("message", "Thêm sản phẩm thành công");
				return "redirect:/admin/list-product";
			}
			catch (Exception e) {
				model.addAttribute("message", "Lỗi lưu file !");
				model.addAttribute("listcbobrand", brandService.findAllBrand());
				model.addAttribute("listcbocategory", categoryService.getAllCategory());
				model.addAttribute("formProduct", product);
				return "redirect:/admin/add-new-product";
			}
		}
//		model.addAttribute("listcbobrand", brandService.findAllBrand());
//		model.addAttribute("listcbocategory", categoryService.getAllCategory());
//		model.addAttribute("formProduct", product);

	}
	
	@PostMapping("/update-product")
	public String doPostUpdateProduct(RedirectAttributes model,@RequestParam("image") List<MultipartFile> images, Product product) {
		if(images.isEmpty()) {
			productService.saveProduct(product);
			model.addFlashAttribute("message", "Update thành công.");
			model.addFlashAttribute("formProduct",product);
		}else {
//			StringBuilder imageFileNames = new StringBuilder();
			try {
				deleteOldImages(product);

				StringBuilder imageFileNames = new StringBuilder();
				for (MultipartFile image : images) {
					String filename = image.getOriginalFilename();
					File file = new File(app.getRealPath("/image/" + filename));
					image.transferTo(file);
					if (imageFileNames.length() > 0) {
						imageFileNames.append(",");
					}
					imageFileNames.append(filename);
				}
//				String filename = images.getOriginalFilename();
//				File file = new File(app.getRealPath("/image/"+filename));
//				images.transferTo(file);

				product.setImg(imageFileNames.toString());
				product.getBrand().setId(product.getBrand().getId());
				product.getCategory().setId(product.getCategory().getId());
				productService.saveProduct(product);
				model.addAttribute("message",product);
				model.addAttribute("listcbobrand", brandService.findAllBrand());
				model.addAttribute("listcbocategory", categoryService.getAllCategory());
				model.addAttribute("formProduct",product);
				return "redirect:/admin/list-product";
			} 
			catch (Exception e) {
				model.addFlashAttribute("message",product.getName());
				model.addFlashAttribute("message", "Lỗi lưu file cho sản phẩm !" );
				return "update_product";
			}
		}
		return "redirect:/admin/list-product";
	}
	private void deleteOldImages(Product product) {
		if (product.getId() != null) {
			Product existingProduct = productService.findById(product.getId());
			if (existingProduct != null && existingProduct.getImg() != null) {
				String[] oldImageNames = existingProduct.getImg().split(",");
				for (String oldImageName : oldImageNames) {
					File oldImageFile = new File(app.getRealPath("/image/" + oldImageName));
					if (oldImageFile.exists()) {
						oldImageFile.delete();
					}
				}
			}
		}
	}
	@GetMapping("/delete-product")
	public String deleteProduct(@RequestParam("id") String idProduct, RedirectAttributes model) throws IOException {
		Product product = productService.findById(idProduct);
		String imgList = product.getImg();
		String[] imgNames = imgList.split(",");
		for (String imgName : imgNames) {
			Path path = Paths.get("src/main/webapp/image/" + imgName.trim());
			try {
				Files.delete(path);
			} catch (IOException e) {
				// Xử lý lỗi nếu có
				e.printStackTrace();
			}
		}
		productService.deleteProductById(idProduct);
		model.addFlashAttribute("message","Xoá thành công sản phẩm mã : "+ idProduct );
		return "redirect:/admin/list-product";
	}
}


