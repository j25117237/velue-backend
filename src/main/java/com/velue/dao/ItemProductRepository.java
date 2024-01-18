package com.velue.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.velue.SalesByProductResponse;
import com.velue.TopProductsResponse;
import com.velue.dto.ItemProduct;

@Repository
public interface ItemProductRepository
  extends JpaRepository<ItemProduct, Long> {
  // List<Item> findAll();

  //  @Query("Select itemProduct FROM ItemProduct itemProduct WHERE itemProduct.createdAt>= :startDate AND itemProduct.createdAt <= :endDate")

  // SELECT SUM(order_quantity) AS 'Total', velue.itemproduct.product_id, velue.product.product_name, velue.product.stock_in_hand, velue.product.price_per_package, velue.product.price_per_package*SUM(order_quantity) as total_amount
  // FROM velue.itemproduct INNER JOIN  velue.product on velue.itemproduct.product_id =velue.product.product_id
  // Where velue.itemproduct.updated_at<="2023-08-10"
  // GROUP BY product_id;

  @Query(
    "SELECT SUM(itemProduct.orderQuantity) AS orderQuantity, itemProduct.productId as productId, product.productName as productName, product.stockInHand as stockInHand, product.pricePerPackage as pricePerPackage FROM ItemProduct itemProduct INNER JOIN Product product on itemProduct.productId = product.productId WHERE itemProduct.createdAt>= :startDate AND itemProduct.createdAt <= :endDate GROUP BY itemProduct.productId"
  )
  List<SalesByProductResponse> getSalesByProduct(
    @Param("startDate") Date startDate,
    @Param("endDate") Date endDate
  );

  @Query(
    "select sum(itemProduct.orderQuantity) as total, itemProduct.productId as productId , product.productName as productName FROM ItemProduct itemProduct  INNER JOIN Product product on itemProduct.productId = product.productId WHERE itemProduct.createdAt>= :startDate AND itemProduct.createdAt <= :endDate " +
    "group by itemProduct.productId " +
    "order by itemProduct.productId"
  )
  public List<TopProductsResponse> getTopProducts(
    @Param("startDate") Date startDate,
    @Param("endDate") Date endDate
  );
}
