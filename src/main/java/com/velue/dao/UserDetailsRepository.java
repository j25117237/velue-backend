package com.velue.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.velue.dto.UserDetails;

@Repository
public interface UserDetailsRepository
  extends JpaRepository<UserDetails, Long> {
  @Query(
    "Select userDetails FROM UserDetails userDetails WHERE userDetails.emailAddress=:email AND userDetails.password=:password"
  )
  public UserDetails findByEmailAddressAndPassword(
    String email,
    String password
  );

  @Query(
    "Select userDetails FROM UserDetails userDetails WHERE userDetails.firstName LIKE  %:name% OR userDetails.lastName LIKE %:name%"
  )
  public List<UserDetails> findByUserName(String name);
}
