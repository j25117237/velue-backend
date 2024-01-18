package com.velue.services;

import java.util.List;

import com.velue.dto.Category;

public interface CategoryService {

	public List <Category> getCategoryByBrand(Long brandId);
}
