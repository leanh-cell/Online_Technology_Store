package com.doapp.nanogear.service;

import java.util.List;

import com.doapp.nanogear.dto.BrandDTO;
import com.doapp.nanogear.entity.Brand;


public interface BrandService {
	
	List<BrandDTO> findBrandByCategory(int idCategory);
	
	List<Brand> findAllBrand();
	
	Brand saveBrand(Brand brand);
	
	Brand findById(int idBrand);
}
