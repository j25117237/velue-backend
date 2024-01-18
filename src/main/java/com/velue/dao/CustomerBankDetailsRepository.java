package com.velue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velue.dto.CustomerBankDetails;

@Repository
public interface CustomerBankDetailsRepository extends JpaRepository<CustomerBankDetails, Long> {

}
