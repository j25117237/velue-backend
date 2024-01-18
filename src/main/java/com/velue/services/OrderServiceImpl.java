package com.velue.services;

import com.velue.dao.ItemProductRepository;
import com.velue.dao.OrderRepository;
import com.velue.dto.ItemProduct;
import com.velue.dto.Order;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private ItemProductRepository itemProductRepository;

  @Override
  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  @Override
  public Optional<Order> getOrderById(Long id) {
    // Order order = orderRepository.findById(id)
    // .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    // return order;
    Optional<Order> order = orderRepository.findById(id);
    return order;
  }

  @Override
  public Optional<Order> getOrderByGST(String gstId) {
    Optional<Order> retrievedOrder = orderRepository.findOrderByGST(gstId);
    return retrievedOrder;
  }

  @Override
  public Order createOrder(Order order) {
	  
    return orderRepository.save(order);
  }

  @Override
  public ItemProduct createItemProduct(ItemProduct itemProduct) {
    return itemProductRepository.save(itemProduct);
  }

  @Override
  public ItemProduct updateItemProduct(ItemProduct itemProduct) {
    return itemProductRepository.save(itemProduct);
  }

  @Override
  public Optional<ItemProduct> getItemProductById(Long id) {
    return itemProductRepository.findById(id);
  }

  @Override
  public Order updateOrder(Optional<Order> existingOrder) {
    return orderRepository.save(existingOrder.get());
  }

  @Override
  public Order updateOrderStatus(Long id, String status) {
    Optional<Order> existingOrder = orderRepository.findById(id);
    if (existingOrder.isPresent()) {
      existingOrder.get().setOrderStatus(status);
    }

    return orderRepository.save(existingOrder.get());
  }

  @Override
  public void deleteOrder(Long id) {
    orderRepository.deleteById(id);
  }

  @Override
  public List<Order> getOrderByStatus(String status) {
    List<Order> orders = orderRepository.findOrderByStatus(status);

    return orders;
  }

  @Override
  public List<Order> findOrderByCustomerAndCreatedDate(
    Long customerId,
    Date startDate,
    Date endDate
  ) {
    List<Order> orders = orderRepository.findOrderByCustomerAndCreatedDate(
      customerId,
      startDate,
      endDate
    );

    return orders;
  }
}
