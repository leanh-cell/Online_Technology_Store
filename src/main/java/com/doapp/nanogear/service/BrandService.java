package com.doapp.nanogear.service;

import java.util.List;
import java.util.Optional;

import com.doapp.nanogear.dto.BrandDTO;
import com.doapp.nanogear.entity.Brand;
import com.doapp.nanogear.entity.Product;
import org.springframework.data.domain.Page;


public interface BrandService {
	
	List<BrandDTO> findBrandByCategory(int idCategory);
	
	List<Brand> findAllBrand();
	
	Brand saveBrand(Brand brand);
	
	Brand findById(int idBrand);

	Page<Brand> findByBrandKeyWordAndPage(Optional<String> key, Optional<Integer> p);

	void deleteBrandById(int id);

}
