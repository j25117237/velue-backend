package com.velue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velue.dto.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {}
