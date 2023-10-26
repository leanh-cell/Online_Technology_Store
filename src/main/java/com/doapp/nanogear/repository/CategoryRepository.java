package com.doapp.nanogear.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doapp.nanogear.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	
}
