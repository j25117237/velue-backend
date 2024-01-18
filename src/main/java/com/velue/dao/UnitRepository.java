package com.velue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velue.dto.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
	// List<Item> findAll();

}
