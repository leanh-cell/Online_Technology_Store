package com.doapp.nanogear.service.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doapp.nanogear.dto.BrandDTO;
import com.doapp.nanogear.entity.Brand;
import com.doapp.nanogear.repository.BrandRepository;
import com.doapp.nanogear.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	BrandRepository brandRepository;
	
	@Override
	public List<BrandDTO> findBrandByCategory(int idCategory) {
		return brandRepository.findBrandByCategory(idCategory);
	}

	@Override
	public List<Brand> findAllBrand() {
		return brandRepository.findAll();
	}

	@Override
	public Brand saveBrand(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public Brand findById(int idBrand) {
		return brandRepository.findById(idBrand).get();
	}

}
