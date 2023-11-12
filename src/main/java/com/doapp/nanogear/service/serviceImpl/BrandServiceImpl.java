package com.doapp.nanogear.service.serviceImpl;
import java.util.List;
import java.util.Optional;

import com.doapp.nanogear.been.SessionService;
import com.doapp.nanogear.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.doapp.nanogear.dto.BrandDTO;
import com.doapp.nanogear.entity.Brand;
import com.doapp.nanogear.repository.BrandRepository;
import com.doapp.nanogear.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	BrandRepository brandRepository;

	@Autowired
	SessionService sessionService;
	
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

	@Override
	public Page<Brand> findByBrandKeyWordAndPage(Optional<String> keyWord, Optional<Integer> p) {
		String kw = keyWord.orElse(sessionService.get("keywords", ""));
		sessionService.set("keywords", kw);
		Pageable pageable = PageRequest.of(p.orElse(0), 8);
		return brandRepository.findByBrandKeyWordAndPage("%" + kw + "%", pageable);
	}

	@Override
	public void deleteBrandById(int id){
		brandRepository.deleteById(id);
	}

}
