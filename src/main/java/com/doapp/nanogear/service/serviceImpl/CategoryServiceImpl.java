package com.doapp.nanogear.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doapp.nanogear.entity.Category;
import com.doapp.nanogear.repository.CategoryRepository;
import com.doapp.nanogear.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategory() {	
		return categoryRepository.findAll() ;
	}

	@Override
	public void saveCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public Category findById(int id) {
		return categoryRepository.findById(id).get();
	}

}
