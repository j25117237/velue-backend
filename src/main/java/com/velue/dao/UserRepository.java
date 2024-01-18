package com.velue.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velue.dto.User;
@Repository


public interface UserRepository extends JpaRepository<User, Long> {
	@Override
	List<User> findAll();
    List<User> findByfirstNameContainingIgnoreCase(String name);
    //@Query("SELECT u FROM User u WHERE LOWER(u.user_name) LIKE %:userName% OR LOWER(u.email_id) LIKE %:emailId%")
  //  List<User> searchUsers(@Param("userName") String userName, @Param("email_id") String emailId);

    }

