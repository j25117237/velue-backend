package com.velue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velue.dto.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  // List<Role> findAll();

}
