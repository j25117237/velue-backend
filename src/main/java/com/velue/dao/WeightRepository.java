package com.velue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velue.dto.Weight;

@Repository
public interface WeightRepository extends JpaRepository<Weight, Long> {
	// List<Item> findAll();

}
