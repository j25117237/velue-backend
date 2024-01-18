package com.velue.services;

import com.velue.SalesByProductResponse;
import com.velue.dto.Brand;
import com.velue.dto.Category;
import com.velue.dto.ItemProduct;
import com.velue.dto.Packaging;
import com.velue.dto.Product;
import com.velue.dto.Unit;
import com.velue.dto.Weight;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductService {
	public List <Product> getProductByCategory(Long categoryId);
	
  public ItemProduct addPackaging(Packaging packaging);

  public List<Packaging> getAllPackaging();

  public Packaging getPackagingById(Long id);

  public Packaging addNewPackaging(Packaging packaging);

  public Packaging updatePackaging(@RequestBody Packaging packaging);

  public List<Brand> getAllBrand();

  public Brand getBrandById(Long id);

  public Brand addNewBrand(Brand brand);

  public Brand updateBrand(Brand brand);

  public List<Category> getAllCategory();

  public Category updateCategory(Category category);

  public Category getCategoryById(Long categoryId);

  public Category addNewCategory(Category category);

  public List<Unit> getAllUnits();

  public Unit getUnitById(Long UnitId);

  public Unit addNewUnit(Unit unit);

  public Unit updateUnit(@RequestBody Unit unit);

  public List<Weight> getAllWeights();

  public Weight getWeightById(Long WeightId);

  //@Cacheable("addProduct")
  public Product addProduct(Product product);

  public List<Product> addProducts(List<Product> product);

  // @Cacheable("products")
  public List<Product> getAllProducts();

  public List<Product> getProductsByItemCode(String name);

  public Product getProductsById(Long id);

  public Product getProductByName(String name);

  public Product updateProduct(Long id, Product product);

  public Product updateProductStatus(Long id, String status);

  public List<SalesByProductResponse> getSalesByProduct(
    Date startDate,
    Date endDate
  );

  public void deleteBrand(Long id);

  public void deleteUnit(Long id);

  public void deleteCategory(Long id);

  public void deletePackaging(Long id);

  public Page<Product> getAllProductsPage(int page, int size);

  public List<Product> getProductByBrandAndCategory(
    Long brandId,
    Long categoryId
  );

}
