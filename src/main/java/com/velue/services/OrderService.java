package com.velue.services;

import com.velue.dto.ItemProduct;
import com.velue.dto.Order;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderService {
  public List<Order> getAllOrders();

  public Optional<Order> getOrderById(Long id);

  public Optional<Order> getOrderByGST(String gstId);

  public Order createOrder(Order order);

  public Order updateOrder(Optional<Order> existingOrder);

  public Order updateOrderStatus(Long id, String status);

  public void deleteOrder(Long id);

  public List<Order> getOrderByStatus(String status);

  public ItemProduct createItemProduct(ItemProduct itemProduct);

  public ItemProduct updateItemProduct(ItemProduct itemProduct);

  public Optional<ItemProduct> getItemProductById(Long id);

  public List<Order> findOrderByCustomerAndCreatedDate(
    Long customerId,
    Date startDate,
    Date endDate
  );
}
