package com.velue.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.velue.OutstandingResponse;
import com.velue.dto.Customer;
import com.velue.dto.UserDetails;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  List<OutstandingResponse> findByOutstandingLimitGreaterThan(Long outstanding);

List<Customer> findByCustomerNameLike(String string);

@Query(
	    "Select customer FROM Customer customer WHERE customer.customerId=:customerId AND customer.primaryNumber=:primaryNumber"
	  )
	  public Customer findByEmailAddressAndPassword(
	    long customerId,
	    String primaryNumber
	  );
}
