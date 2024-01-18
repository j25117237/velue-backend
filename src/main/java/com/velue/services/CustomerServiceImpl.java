package com.velue.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velue.OutstandingResponse;
import com.velue.dao.BankRepository;
import com.velue.dao.CustomerBankDetailsRepository;
import com.velue.dao.CustomerRepository;
import com.velue.dto.Bank;
import com.velue.dto.Customer;
import com.velue.dto.CustomerBankDetails;
import com.velue.dto.UserDetails;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private BankRepository bankRepository;

  @Autowired
  private CustomerBankDetailsRepository customerBankDetailsRepository;

  /*
   * @Override public Customer getEmployee(String employeeid) { Optional<Customer>
   * result = repo.findById(employeeid); if (result.isPresent()) { Customer
   * employee = result.get(); return employee; } else { throw new
   * RuntimeException("Employee id not found - " + employeeid); } }
   */
  // @Cacheable("customerCache")
  @Override
public List<Customer> getAllCustomers() {
    List<Customer> customerDetails = null;
    try {
      customerDetails = customerRepository.findAll();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return customerDetails;
  }

  @Override
public Customer getCustomerById(Long customerId) {
    // return customerRepository.findById(id).orElseThrow(() -> nnew
    // RuntimeException("Customer not found with id " + id));
    Customer customer = customerRepository
      .findById(customerId)
      .orElseThrow(() ->
        new RuntimeException("Customer not found with id " + customerId)
      );
    return customer;
  }

  @Override
public Customer createCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  @Override
public Customer updateCustomer(Long id, Customer customer) {
    Optional<Customer> existingCustomer = customerRepository.findById(id);
    if (existingCustomer.isPresent()) {
      Customer filteredCustomer = existingCustomer.get();
      org.springframework.beans.BeanUtils.copyProperties(
        customer,
        filteredCustomer
      );
      filteredCustomer.setCustomerId(id);
      return customerRepository.save(customer);
    } else {
      throw new RuntimeException("Customer not found with id " + id);
    }
  }

  @Override
public void deleteCustomer(Long id) {
    customerRepository.deleteById(id);
  }

  @Override
public CustomerBankDetails addCustomerBankDetails(
    CustomerBankDetails bankDetails
  ) {
    return customerBankDetailsRepository.save(bankDetails);
  }

  @Override
public CustomerBankDetails updateCustomerBankDetails(
    Long id,
    CustomerBankDetails customerBankDetails
  ) {
    Optional<CustomerBankDetails> existingCustomerBank = customerBankDetailsRepository.findById(
      id
    );
    if (existingCustomerBank.isPresent()) {
      CustomerBankDetails filteredCustomer = existingCustomerBank.get();
      org.springframework.beans.BeanUtils.copyProperties(
        customerBankDetails,
        filteredCustomer
      );
      filteredCustomer.setBankReferenceId(id);
      return customerBankDetailsRepository.save(customerBankDetails);
    } else {
      throw new RuntimeException("Customer Bank not found with id " + id);
    }
  }

  @Override
public List<OutstandingResponse> getOverdue() {
    Long outstanding = (long) 0;
    // return null;
    return customerRepository.findByOutstandingLimitGreaterThan(outstanding);
    //giving error  so commented for now
  }

  @Override
public List<Customer> getCustomerByName(String name) {
    return customerRepository.findByCustomerNameLike("%" + name + "%");
  }

  @Override
public List<Bank> getBanks() {
    return bankRepository.findAll();
  }
  @Override
  public Customer validateLoginDetails(long customerId, String primaryNumber) {
    return customerRepository.findByEmailAddressAndPassword(customerId, primaryNumber);
  }
}
