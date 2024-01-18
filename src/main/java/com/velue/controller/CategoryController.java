package com.velue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velue.dto.Category;
import com.velue.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
	
	
	 @GetMapping("categoryByBrand/{brandId}")
	 public List <Category> getCategoryByBrand(@PathVariable Long brandId)
	 {
		 System.out.println("==jagan==");
		 return  categoryService.getCategoryByBrand(brandId);
		
	 }
	 
}
