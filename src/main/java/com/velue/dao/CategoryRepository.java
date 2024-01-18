package com.velue.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.velue.dto.Category;
import com.velue.dto.Product;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	// List<Item> findAll();
	
	@Query(
		    "Select category FROM Category category WHERE category.brandId = :brandId "
		  )
		  public List <Category> findCategoryByBrand(Long brandId);

		    
				




}
