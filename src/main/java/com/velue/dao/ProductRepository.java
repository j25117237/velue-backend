package com.velue.dao;

import com.velue.RestockProductsResponse;
import com.velue.dto.Category;
import com.velue.dto.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	@Query(
		    "Select product FROM Product product WHERE product.categoryId = :categoryId "
		  )
		  public List <Product> findProductByCategory(Long categoryId);

  // @Query("Select product FROM Product product WHERE product.productName LIKE
  // :name")
  public Product findByProductNameContainingIgnoreCase(String name);

  @Query(
    "Select product FROM Product product WHERE product.ItemCode LIKE %:code%"
  )
  public List<Product> findProductByItemCode(String code);

  @Query(
    "Select product FROM Product product WHERE product.brandId= :brandId AND product.categoryId= :categoryId "
  )
  public List<Product> findProductByBrandAndCategory(
    Long brandId,
    long categoryId
  );
  
 	 

  @Query(
    " Select productName as productName, reStockLevel as restockLevel, stockInHand as stockInHand   from Product product " +
    "where stockInHand < reStockLevel order by stockInHand"
  )
  public List<RestockProductsResponse> getRestockProducts();

  //@Query("SELECT p.item_code,p.item_description,p.stock_in_hand, p.re_stock_level,u.unit_name FROM product p INNER JOIN category c ON p.category_id = c.category_id INNER JOIN  brand b ON p.brand_id = b.brand_id INNER JOIN unit u ON p.unit_id = u.unit_id")
  //@Query("SELECT p.item_code,p.item_description,p.stock_in_hand, p.re_stock_level,u.unit_name FROM product p ")
  //@Query("Select p.ItemCode ,p.itemDescription ,p.stockInHand, p.reStockLevel ,p.Status,u.unitName from Product p INNER JOIN Category c ON p.categoryId = c.categoryId  INNER JOIN  Brand b ON p.brandId = b.brandId  INNER JOIN Unit u ON p.unitId = u.unitId")
  //public List<Product> getAllProducts();

  // 		SELECT SUM(order_quantity) AS 'Total', product_id
  // FROM velue.itemproduct Where updated_at<="2023-08-10"
  // GROUP BY product_id ;
  @Override
  public Page<Product> findAll(Pageable pageable);
}
