package com.doapp.nanogear.service;

import java.util.List;

import com.doapp.nanogear.entity.Category;

public interface CategoryService {
	
	List<Category> getAllCategory();
	
	void saveCategory(Category category);
	
	Category findById(int id);
}
