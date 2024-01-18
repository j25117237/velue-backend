package com.velue.services;

import com.velue.SalesByProductResponse;
// import com.velue.dto.ItemProduct;
import com.velue.dao.BrandRepository;
import com.velue.dao.CategoryRepository;
import com.velue.dao.ItemProductRepository;
import com.velue.dao.PackagingRepository;
import com.velue.dao.ProductRepository;
import com.velue.dao.UnitRepository;
import com.velue.dao.WeightRepository;
import com.velue.dto.Brand;
import com.velue.dto.Category;
import com.velue.dto.ItemProduct;
import com.velue.dto.Packaging;
import com.velue.dto.Product;
import com.velue.dto.Unit;
import com.velue.dto.Weight;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
//@CacheConfig(cacheNames = "productsCache")
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private PackagingRepository packagingRepository;

  @Autowired
  private BrandRepository brandRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private UnitRepository unitRepository;

  @Autowired
  private WeightRepository weightRepository;

  @Autowired
  private ItemProductRepository itemProductRepository;
  
  @Override
  public List <Product> getProductByCategory(Long categoryId)
	{
		return  productRepository.findProductByCategory(categoryId);
			    
			  
	}

  @Override
  public Product addProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public List<Product> addProducts(List<Product> products) {
    return productRepository.saveAll(products);
  }

  @Override
  //@Cacheable("products")
  //@Cacheable("productsCache")
  public List<Product> getAllProducts() {
    // System.out.println("==jagan entered once==");
    return productRepository.findAll();
    //return productRepository.getAllProducts();
  }

  /*
   * @Override public Product getProductById(Long id) { return
   * productRepository.findById(id); //return null; }
   */

  @Override
  public ItemProduct addPackaging(Packaging packaging) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Packaging> getAllPackaging() {
    return packagingRepository.findAll();
  }

  @Override
  public Packaging addNewPackaging(Packaging packaging) {
    return packagingRepository.save(packaging);
  }

  @Override
  public List<Brand> getAllBrand() {
    // TODO Auto-generated method stub
    return brandRepository.findAll();
  }

  @Override
  public Brand addNewBrand(Brand brand) {
    return brandRepository.save(brand);
  }

  // public Brand updateBrand(Long id, Brand brand) {
  //   return brandRepository.save(brand);
  // }

  @Override
  public List<Category> getAllCategory() {
    return categoryRepository.findAll();
  }

  @Override
  public Category addNewCategory(Category category) {
    return categoryRepository.save(category);
  }

  @Override
  public List<Unit> getAllUnits() {
    return unitRepository.findAll();
  }

  @Override
  public Unit addNewUnit(Unit unit) {
    return unitRepository.save(unit);
  }

  @Override
  public List<Weight> getAllWeights() {
    return weightRepository.findAll();
  }

  @Override
  public Packaging getPackagingById(Long packageId) {
    return packagingRepository
      .findById(packageId)
      .orElseThrow(() ->
        new RuntimeException("Product not found with id " + packageId)
      );
  }

  @Override
  public List<Product> getProductsByItemCode(String itemCode) {
    List<Product> product = productRepository.findProductByItemCode(itemCode);
    // .orElseThrow(() -> new RuntimeException("Product not found with id " + id));

    return product;
  }

  @Override
  public Product getProductsById(Long id) {
    //System.out.println(" ==jagan id =="+id);
    Product product = productRepository
      .findById(id)
      .orElseThrow(() -> new RuntimeException("Product not found with id " + id)
      );

    return product;
  }

  @Override
  public Product getProductByName(String name) {
    Product product = productRepository.findByProductNameContainingIgnoreCase(
      name
    );
    // .orElseThrow(() -> new RuntimeException("Product not found with name " +
    // name));

    return product;
  }

  @Override
  public Product updateProduct(Long id, Product product) {
    Optional<Product> existingProduct = productRepository.findById(id);
    if (existingProduct.isPresent()) {
      Product filteredProduct = existingProduct.get();
      org.springframework.beans.BeanUtils.copyProperties(
        product,
        filteredProduct
      );
      filteredProduct.setProductId(id);
      return productRepository.save(product);
    } else {
      throw new RuntimeException("Product not found with id " + id);
    }
  }

  @Override
  public Product updateProductStatus(Long id, String status) {
    Optional<Product> existingProduct = productRepository.findById(id);
    if (existingProduct.isPresent()) {
      existingProduct.get().setStatus(status);
    }
    return productRepository.save(existingProduct.get());
  }

  @Override
  public Brand getBrandById(Long brandId) {
    return brandRepository
      .findById(brandId)
      .orElseThrow(() ->
        new RuntimeException("Brand not found with id " + brandId)
      );
  }

  @Override
  public Category getCategoryById(Long categoryId) {
    return categoryRepository
      .findById(categoryId)
      .orElseThrow(() ->
        new RuntimeException("Category not found with id " + categoryId)
      );
  }

  @Override
  public Unit getUnitById(Long unitId) {
    return unitRepository
      .findById(unitId)
      .orElseThrow(() ->
        new RuntimeException("Unit not found with id " + unitId)
      );
  }

  @Override
  public Weight getWeightById(Long weightId) {
    return weightRepository
      .findById(weightId)
      .orElseThrow(() ->
        new RuntimeException("Weight not found with id " + weightId)
      );
  }

  @Override
  public List<SalesByProductResponse> getSalesByProduct(
    Date startDate,
    Date endDate
  ) {
    return itemProductRepository.getSalesByProduct(startDate, endDate);
  }

  @Override
  public Brand updateBrand(Brand brand) {
    return brandRepository.save(brand);
  }

  @Override
  public Packaging updatePackaging(Packaging packaging) {
    return packagingRepository.save(packaging);
  }

  @Override
  public Category updateCategory(Category category) {
    return categoryRepository.save(category);
  }

  @Override
  public Unit updateUnit(Unit unit) {
    return unitRepository.save(unit);
  }

  @Override
  public void deleteBrand(Long id) {
    brandRepository.deleteById(id);
  }

  @Override
  public void deleteUnit(Long id) {
    unitRepository.deleteById(id);
  }

  @Override
  public void deleteCategory(Long id) {
    categoryRepository.deleteById(id);
  }

  @Override
  public void deletePackaging(Long id) {
    packagingRepository.deleteById(id);
  }

  @Override
  public Page<Product> getAllProductsPage(int page, int size) {
    PageRequest pageRequest = PageRequest.of(page, size);
    return productRepository.findAll(pageRequest);
  }

  @Override
  public List<Product> getProductByBrandAndCategory(
    Long brandId,
    Long categoryId
  ) {

    return productRepository.findProductByBrandAndCategory(brandId, categoryId);
  }
  
 
}
