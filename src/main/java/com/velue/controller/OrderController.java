package com.velue.controller;

import com.velue.dto.Batch;
import com.velue.dto.Customer;
import com.velue.dto.ItemProduct;
import com.velue.dto.Order;
import com.velue.dto.OrderBatch;
import com.velue.dto.Product;
import com.velue.services.BatchService;
import com.velue.services.CustomerService;
import com.velue.services.OrderService;
import com.velue.services.ProductService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @Autowired
  private BatchService batchService;

  @Autowired
  private CustomerService customerService;

  @Autowired
  private ProductService productService;

  // @GetMapping("/getAllOrders")
  // public List<Order> getAllOrders() {
  // return orderService.getAllOrders();
  // }

  @GetMapping("/getAllOrders")
  public List<Order> getAllOrders() {
    List<Order> orders = orderService.getAllOrders();
    // System.out.println("==getAllOrders=="+orders);
    // List<OrderList> orderList = new ArrayList<>();

    for (Order order : orders) {
      // System.out.println("==order.getCustomerId()==" +
      // order.getCustomer().getCustomerId());
      // Customer customer = customerService.getCustomerById(order.getCustomerId());
      // System.out.println("==gstno==" + customer.getGstno());
      // OrderList orderList1 = new OrderList();
      // orderList1.setGstno(customer.getGstno());
      // // orderList1.setFirstName(customer.getLastName());
      // // orderList1.setLastName(customer.getLastName());
      // orderList1.setOrderStatus(order.getOrderStatus());
      // orderList.add(orderList1);

      for (ItemProduct product : order.product) {
        // System.out.println("order.product===="+order.product.size());

        long productId = product.getProductId();
        // System.out.println("ItemProduct===="+productId);

        Product productDetails = productService.getProductsById(productId);
        // System.out.println("productDetails===="+productDetails);
        // System.out.println("productDetails
        // getProductName===="+productDetails.getProductName());

        product.setProductName(productDetails.getProductName());
        product.setProductDescription(productDetails.getProductDescription());
        product.setItemDescription(productDetails.getItemDescription());
        product.setPricePerPackage(productDetails.getPricePerPackage());
        product.setPackagingType(productDetails.getPacking_type());
        // product.setImage(productDetails.getImage());
        product.setItemCode(productDetails.getItemCode());
        product.setAmount(
          product.getOrderQuantity() * product.getPricePerPackage()
        );
      }
    }

    return orders;
  }

  // @GetMapping("/{id}")
  // public Order getOrderByID(@PathVariable Long id, @RequestParam
  // VelueConstants.SearchType searchType) {
  // Order order = null;
  // if (searchType == VelueConstants.SearchType.ORDER_ID) {
  // order = orderService.getOrderById(id);
  // } else {
  // order = orderService.getOrderByGST(id);
  // }

  // for (ItemProduct product : order.product) {
  // long productId = product.getProductId();
  // Product productDetails = productService.getProductsById(productId);
  // product.setProductName(productDetails.getProductName());
  // product.setProductDescription(productDetails.getProductDescription());
  // }

  // return order;
  // }

  @GetMapping("/search/gst/{gstNo}")
  public Optional<Order> getOrderByGST(@PathVariable String gstNo) {
    Optional<Order> order = orderService.getOrderByGST(gstNo);
    if (order.isPresent()) {
      for (ItemProduct product : order.get().getProduct()) {
        long productId = product.getProductId();
        Product productDetails = productService.getProductsById(productId);
        product.setProductName(productDetails.getProductName());
        product.setProductDescription(productDetails.getProductDescription());
        product.setItemDescription(productDetails.getItemDescription());
        product.setPricePerPackage(productDetails.getPricePerPackage());
        product.setPackagingType(productDetails.getPacking_type());
        product.setAmount(
          product.getOrderQuantity() * product.getPricePerPackage()
        );
      }
    }

    return order;
  }

  @GetMapping("/search/id/{id}")
  public Optional<Order> getOrderByID(@PathVariable Long id) {
    Optional<Order> order = orderService.getOrderById(id);
    if (order.isPresent()) {
      for (ItemProduct product : order.get().getProduct()) {
        long productId = product.getProductId();
        Product productDetails = productService.getProductsById(productId);
        product.setProductName(productDetails.getProductName());
        product.setProductDescription(productDetails.getProductDescription());
        product.setItemDescription(productDetails.getItemDescription());
        product.setPricePerPackage(productDetails.getPricePerPackage());
        product.setPackagingType(productDetails.getPacking_type());
        product.setAmount(
          product.getOrderQuantity() * product.getPricePerPackage()
        );
      }
    }
    return order;
  }

  @PostMapping("/add")
  public Order createOrder(@RequestBody Order order) {
    List<ItemProduct> productsForThisOrder = order.product;

    List<ItemProduct> products = new ArrayList<>();

    order.setProduct(products);

    Order newOrder = orderService.createOrder(order);
    for (ItemProduct product : productsForThisOrder) {
      product.setOrderId(newOrder.getOrderId());
      product.setRemainingQuantity(product.getOrderQuantity());
      orderService.createItemProduct(product);
      products.add(product);
    }
    newOrder.setProduct(products);

    return newOrder;
  }

  @PutMapping("/update/{id}")
  public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
    Optional<Order> existingOrder = orderService.getOrderById(id);
    if (existingOrder.isPresent()) {
      existingOrder.get().setOrderStatus(order.getOrderStatus());
      existingOrder.get().setTotalAmount(order.getTotalAmount());

      List<ItemProduct> existingProducts = existingOrder.get().getProduct();

      for (ItemProduct product : order.product) {
        long productId = product.getProductId();

        for (ItemProduct existingProduct : existingProducts) {
          if (existingProduct.getProductId() == productId) {
            existingProduct.setOrderQuantity(product.getOrderQuantity());
            orderService.updateItemProduct(existingProduct);
          } else {
            if (product.getOrderProductId() == null) {
              product.setOrderId(id);
              product.setRemainingQuantity(product.getOrderQuantity());

              orderService.createItemProduct(product);
            }
          }
        }
      }
    }
    return orderService.updateOrder(existingOrder);
  }

  @PutMapping("update/{id}/status/{status}")
  public Order updateOrderStatus(
    @PathVariable Long id,
    @PathVariable String status,
    @RequestBody Order UpdatedOrder
  ) {
    if (status.trim().equals("Accepted")) {
      Optional<Order> order = orderService.getOrderById(id);

      for (ItemProduct itemProduct : order.get().getProduct()) {
        long productId = itemProduct.getProductId();
        Product product = productService.getProductsById(productId);
        product.setStockInHand(
          product.getStockInHand() - itemProduct.getOrderQuantity()
        );
      }
    }

    // System.out.println("status checking" + status.trim().equals("Accepted"));
    if (status.trim().equals("Delivered")) {
      Optional<Order> order = orderService.getOrderById(id);
      long customerID = order.get().getCustomerId();
      Customer customer = customerService.getCustomerById(customerID);
      customer.setOutstandingLimit(order.get().getTotalAmount());
    }

    if (status.trim().equals("InTransit")) {
      Optional<Order> order = orderService.getOrderById(id);
      String intermediateStatus = "InTransit";
      List<Batch> batchList = batchService.getBatchByOrderId(id);
      long customerID = order.get().getCustomerId();
      Customer customer = customerService.getCustomerById(customerID);
      String customerName = customer.getCustomerName();
      Long invoiceAmount = (long) 0;
      // Long TotalAmount = 0;
      Batch newBatch = new Batch();
      order.get().getOrderId();
    //  newBatch.setBatchNumber("Batch" + (batchList.size() + 1));

      newBatch.setBatchNumber(order.get().getOrderId()+"-" + (batchList.size() + 1));
      newBatch.setOrderId(id);
     // newBatch.setStatus("Billed");
      newBatch.setStatus("InTransit");
     // InTransit
      newBatch.setCustomerName(customerName);
      // newBatch.setCustomerName(customerName);

      Batch updatedBatch = batchService.createBatch(newBatch);

      List<OrderBatch> newOrderBatch = UpdatedOrder.getOrderBatches();
      for (OrderBatch orderBatch : newOrderBatch) {
        Long dispatchQuantity = orderBatch.getDispatchQuantity();
        Long itemProductId = orderBatch.getOrderProductId();
        Long productAmount = orderBatch.getInvoiceAmount();
        invoiceAmount += productAmount;
        Optional<ItemProduct> itemProduct = orderService.getItemProductById(
          itemProductId
        );
        if (itemProduct.isPresent()) {
          Long orderQuantity = itemProduct.get().getOrderQuantity();
          Long remainingQuantity = itemProduct.get().getRemainingQuantity();
          if (remainingQuantity != null) {
            itemProduct
              .get()
              .setRemainingQuantity(remainingQuantity - dispatchQuantity);
          } else {
            itemProduct
              .get()
              .setRemainingQuantity(orderQuantity - dispatchQuantity);
          }
          remainingQuantity = itemProduct.get().getRemainingQuantity();
          if (remainingQuantity > 0) {
            intermediateStatus = "PartialDelivered";
          }
        }

        orderBatch.setBatchId(updatedBatch.getBatchId());
        if (orderBatch.getDispatchQuantity() != 0) {
          batchService.createOrderBatch(orderBatch);
        }
      }
      batchService.updateBatchInvoiceAmount(
        updatedBatch.getBatchId(),
        invoiceAmount
      );

      return orderService.updateOrderStatus(id, intermediateStatus);
    }
    return orderService.updateOrderStatus(id, status);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteOrder(@PathVariable Long id) {
    orderService.deleteOrder(id);
  }

  @GetMapping("/search/status/{status}")
  public List<Order> getOrderByStatus(@PathVariable String status) {
    List<Order> orders;

    orders = orderService.getOrderByStatus(status);

    return orders;
  }

  @GetMapping("/search/salesByCustomer")
  public List<Order> getSalesByCustomer(
    @RequestParam("customerId") Long customerId,
    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
  ) {
    return orderService.findOrderByCustomerAndCreatedDate(
      customerId,
      startDate,
      endDate
    );
  }
}
