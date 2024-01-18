package com.velue.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velue.dao.CategoryRepository;
import com.velue.dto.Category;


@Service
public class CategoryServiceImpl implements CategoryService
{
	  @Autowired
    private CategoryRepository categoryRepository;
	  @Override  
	public List <Category> getCategoryByBrand(Long brandId)
	{
		return  categoryRepository.findCategoryByBrand(brandId);
			    
			  
	}
	
}
