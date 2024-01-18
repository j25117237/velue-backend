package com.velue.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velue.DashboardStats;
import com.velue.RestockProductsResponse;
import com.velue.SalesStatsResponse;
import com.velue.TopProductsResponse;
import com.velue.services.DashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

  @Autowired
  private DashboardService dashboardService;

  @GetMapping("/stats")
  public DashboardStats getStats() {
    return dashboardService.getStats();
  }

  @GetMapping("/saleschartstats")
  public List<SalesStatsResponse> getSalesStats(
    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
  ) {
    return dashboardService.getSalesStats(startDate, endDate);
  }

  @GetMapping("/topProducts")
  public List<TopProductsResponse> getTopProducts(
    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
  ) {
    return dashboardService.getTopProducts(startDate, endDate);
  }

  @GetMapping("/restockProducts")
  public List<RestockProductsResponse> getRestockProducts() {
    return dashboardService.getRestockProducts();
  }

}
