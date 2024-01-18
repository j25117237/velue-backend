package com.velue.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.velue.DashboardStats;
import com.velue.SalesStatsResponse;
import com.velue.dto.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  @Query("Select order FROM Order order WHERE order.customer.gstno = :gst")
  public Optional<Order> findOrderByGST(@Param("gst") String GST);

  @Query("Select order FROM Order order WHERE order.orderStatus= :status")
  public List<Order> findOrderByStatus(@Param("status") String status);

  @Query(
    "Select order FROM Order order WHERE order.customerId= :customerId AND order.createdAt >= :startDate AND order.createdAt <= :endDate "
  )
  public List<Order> findOrderByCustomerAndCreatedDate(
    @Param("customerId") Long customerId,
    @Param("startDate") Date startDate,
    @Param("endDate") Date endDate
  );

  @Query(
    "Select DISTINCT( Select count(*) from  Order order where orderStatus!='Delivered') AS pendingOrders," +
    "(SELECT COUNT(*) from Order order ) AS totalOrders," +
    "(SELECT SUM(totalAmount) from Order order) AS sales," +
    "(SELECT COUNT(*) from Customer customer ) AS customers," +
    "(SELECT SUM(overdue) from Customer customer ) AS pendingAmount FROM Order,Customer"
  )
  public DashboardStats getStats();

  @Query(
    "SELECT SUM(totalAmount) AS total,  CAST(updatedAt AS date) as deliveredDate from Order order where orderStatus='Delivered' " +
    "AND updatedAt>=:startDate AND CAST(updatedAt AS date) <=:endDate " +
    "group by CAST(updatedAt AS date) order by  CAST(updatedAt AS date)"
  )
  public List<SalesStatsResponse> getSalesStats(
    @Param("startDate") Date startDate,
    @Param("endDate") Date endDate
  );
  
  
  
  
}

