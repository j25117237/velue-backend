package com.velue.services;

import java.util.List;

import com.velue.OutstandingResponse;
import com.velue.dto.Bank;
import com.velue.dto.Customer;
import com.velue.dto.CustomerBankDetails;
import com.velue.dto.UserDetails;

public interface CustomerService {
  public List<Customer> getAllCustomers();

  public Customer getCustomerById(Long customerId);

  public Customer createCustomer(Customer customer);

  public Customer updateCustomer(Long id, Customer customer);

  public List<Customer> getCustomerByName(String name);

  public void deleteCustomer(Long id);

  public CustomerBankDetails addCustomerBankDetails(
    CustomerBankDetails customerBankDetails
  );

  public CustomerBankDetails updateCustomerBankDetails(
    Long id,
    CustomerBankDetails customerBankDetails
  );

  public List<OutstandingResponse> getOverdue();

  public List<Bank> getBanks();
  public Customer validateLoginDetails(long customerId, String primaryNumber);


}
