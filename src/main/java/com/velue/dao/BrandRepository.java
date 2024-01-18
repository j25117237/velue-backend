package com.velue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velue.dto.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
	// List<Item> findAll();

}
