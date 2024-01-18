package com.velue.services;

import com.velue.dao.BatchRepository;
import com.velue.dao.OrderBatchRepository;
import com.velue.dto.Batch;
import com.velue.dto.OrderBatch;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchServiceImpl implements BatchService {

  @Autowired
  private BatchRepository batchRepository;

  @Autowired
  private OrderBatchRepository orderBatchRepository;

  @Override
  public List<Batch> getAllBatches() {
    return batchRepository.findAll();
  }

  @Override
  public Optional<Batch> getBatchById(Long id) {
    Optional<Batch> batch = batchRepository.findById(id);
    return batch;
  }

  @Override
  public List<Batch> getBatchByOrderId(Long orderId) {
    return batchRepository.findBatchByOrderId(orderId);
  }

  @Override
  public Batch updateBatchInvoiceAmount ( Long id, Long invoiceAmount){
    Optional<Batch> existingBatch = batchRepository.findById(id);
    if(existingBatch.isPresent()){
      existingBatch.get().setInvoiceAmount(invoiceAmount);
    }
    return batchRepository.save(existingBatch.get());
  }

  @Override
  public Batch createBatch(Batch batch) {
    return batchRepository.save(batch);
  }

  @Override
  public OrderBatch createOrderBatch(OrderBatch orderBatch) {
    return orderBatchRepository.save(orderBatch);
  }

  @Override
  public List<OrderBatch> getOrderBatchByOrderId(Long orderId) {
    return orderBatchRepository.findOrderBatchByOrderId(orderId);
  }

  @Override
  public List<OrderBatch> getAllOrderBatches() {
    return orderBatchRepository.findAll();
  }
  
}
