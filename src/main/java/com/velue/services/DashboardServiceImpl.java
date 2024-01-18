package com.velue.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velue.DashboardStats;
import com.velue.RestockProductsResponse;
import com.velue.SalesStatsResponse;
import com.velue.TopProductsResponse;
import com.velue.dao.ItemProductRepository;
import com.velue.dao.OrderRepository;
import com.velue.dao.ProductRepository;

@Service
public class DashboardServiceImpl implements DashboardService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private ItemProductRepository itemProductRepository;

  @Autowired
  private ProductRepository productRepository;

  @Override
public DashboardStats getStats() {
    return orderRepository.getStats();
  }

  @Override
public List<SalesStatsResponse> getSalesStats(Date startDate, Date endDate) {
    return orderRepository.getSalesStats(startDate, endDate);
  }

  @Override
public List<TopProductsResponse> getTopProducts(
    Date startDate,
    Date endDate
  ) {
    return itemProductRepository.getTopProducts(startDate, endDate);
  }

  @Override
public List<RestockProductsResponse> getRestockProducts() {
    return productRepository.getRestockProducts();
  }
}
