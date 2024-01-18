package com.velue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velue.dto.Bank;
import com.velue.dto.Customer;
import com.velue.dto.CustomerBankDetails;
import com.velue.dto.UserDetails;
import com.velue.services.CustomerService;

@RestController
@RequestMapping("/customer/")
public class CustomerController {

  private CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/getAllCustomers")
  public List<Customer> findAllCustomers() {
    return customerService.getAllCustomers();
  }

  @GetMapping("/{id}")
  public Customer getCustomerById(@PathVariable Long id) {
    return customerService.getCustomerById(id);
  }

  @GetMapping("/search/name/{name}")
  public List<Customer> getCustomerByName(@PathVariable String name) {
    return customerService.getCustomerByName(name);
  }

  @PostMapping("/saveCustomers")
  public Customer createCustomer(@RequestBody Customer customer) {
    CustomerBankDetails bankDetails = customer.getCustomerBank();
    CustomerBankDetails addedDetail = customerService.addCustomerBankDetails(
      bankDetails
    );
    customer.setBankReferenceId(addedDetail.getBankReferenceId());
    return customerService.createCustomer(customer);
  }

  @PutMapping("/update/{id}")
  public Customer updateCustomer(
    @PathVariable Long id,
    @RequestBody Customer customer
  ) {
    CustomerBankDetails bankDetails = customer.getCustomerBank();
    CustomerBankDetails addedDetail = customerService.updateCustomerBankDetails(
      customer.getBankReferenceId(),
      bankDetails
    );
    customer.setBankReferenceId(addedDetail.getBankReferenceId());

    return customerService.updateCustomer(id, customer);
  }

  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
  }

  @GetMapping("/banks")
  public List<Bank> getBanks(){
    return customerService.getBanks();
  }
  @GetMapping("/loginm")
  public Customer validateLoginDetails(
    @RequestParam long customerId,
    @RequestParam String primaryNumber
  ) {
    return customerService.validateLoginDetails(customerId, primaryNumber);
  }
}
