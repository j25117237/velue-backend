package com.velue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velue.dto.UserSalaryDetails;

@Repository
public interface UserSalaryDetailsRepository
  extends JpaRepository<UserSalaryDetails, Long> {}
