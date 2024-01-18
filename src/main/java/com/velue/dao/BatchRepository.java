package com.velue.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.velue.dto.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
  // List<Item> findAll();
  @Query("Select batch FROM Batch batch WHERE batch.orderId= :orderId")
  public List<Batch> findBatchByOrderId(@Param("orderId") Long orderId);
}
