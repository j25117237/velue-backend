package com.velue.controller;

//import com.velue.services.ReportService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velue.OutstandingResponse;
import com.velue.dto.HighSellingProduct;
import com.velue.dto.LowSellingProduct;
import com.velue.dto.PendingOrdersCustomer;
import com.velue.dto.PendingOrdersProduct;
import com.velue.dto.Restock;
import com.velue.services.CustomerService;
import com.velue.services.ReportService;

@RestController
@RequestMapping("/report/")
public class ReportController {

  @Autowired
  private CustomerService customerService;
  @Autowired
  private ReportService reportService;

  @GetMapping("/outstanding")
  public List<OutstandingResponse> getOverdue() {
    return customerService.getOverdue();
  }
  
      
      @GetMapping("/pendingorderscustomer")
      public List<PendingOrdersCustomer> getPendingOrdersByCustomer()
      {
          List<PendingOrdersCustomer> result = reportService.getPendingOrdersByCustomer();
          return  result;
      }
      
      @GetMapping("/pendingordersproduct")
      public List<PendingOrdersProduct> getPendingOrdersByProduct()
      {
          List<PendingOrdersProduct> result = reportService.getPendingOrdersByProduct();
          return  result;
      }
      
      @GetMapping("/highsellingproduct")
      public List<HighSellingProduct> getHighSellingProduct()
      {
          List<HighSellingProduct> result = reportService.getHighSellingProduct();
          return  result;
      }
      @GetMapping("/lowsellingproduct")
      public List<LowSellingProduct> getLowSellingProduct()
      {
          List<LowSellingProduct> result = reportService.getLowSellingProduct();
          return  result;
      }
      @GetMapping("/restock")
      public List<Restock> getRestockReport()
      {
          List<Restock> result = reportService.getRestockReport();
          return  result;
      }
  }


