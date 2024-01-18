package com.velue.services;

import java.util.Date;
import java.util.List;

import com.velue.DashboardStats;
import com.velue.RestockProductsResponse;
import com.velue.SalesStatsResponse;
import com.velue.TopProductsResponse;

public interface DashboardService {
  public DashboardStats getStats();

  public List<SalesStatsResponse> getSalesStats(Date startDate, Date endDate);

  public List<TopProductsResponse> getTopProducts(Date startDate, Date endDate);

  public List<RestockProductsResponse> getRestockProducts();
}
