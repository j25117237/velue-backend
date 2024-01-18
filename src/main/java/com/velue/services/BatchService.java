package com.velue.services;

import com.velue.dto.Batch;
import com.velue.dto.OrderBatch;
import java.util.List;
import java.util.Optional;

public interface BatchService {
  public List<Batch> getAllBatches();

  public Optional<Batch> getBatchById(Long id);

  public List<Batch> getBatchByOrderId(Long orderId);

  public Batch updateBatchInvoiceAmount(Long id, Long invoiceAmount);

  public Batch createBatch(Batch batch);

  public OrderBatch createOrderBatch(OrderBatch batch);

  public List<OrderBatch> getOrderBatchByOrderId(Long orderId);

  public List<OrderBatch> getAllOrderBatches();
}
