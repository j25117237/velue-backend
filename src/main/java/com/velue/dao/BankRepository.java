package com.velue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velue.dto.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
  // List<Item> findAll();

}
