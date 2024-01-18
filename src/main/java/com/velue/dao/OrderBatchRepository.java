package com.velue.dao;

import com.velue.dto.OrderBatch;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBatchRepository extends JpaRepository<OrderBatch, Long> {
  @Query(
    "Select orderBatch FROM OrderBatch orderBatch WHERE orderBatch.orderId= :orderId"
  )
  List<OrderBatch> findOrderBatchByOrderId(Long orderId);
}
