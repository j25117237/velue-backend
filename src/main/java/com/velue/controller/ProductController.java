package com.velue.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.velue.SalesByProductResponse;
import com.velue.constants.VelueConstants;
import com.velue.dto.Brand;
import com.velue.dto.Category;
import com.velue.dto.Packaging;
import com.velue.dto.Product;
import com.velue.dto.Unit;
import com.velue.dto.Weight;
import com.velue.services.ProductService;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/productByCategory/{categoryId}")
	 public List <Product> getProductByCategory(@PathVariable Long categoryId)
	 {
		
		 return  productService.getProductByCategory(categoryId);
		
	 }
  
  @GetMapping("/getAllProducts")
  //@Cacheable("products1")
  // @Cacheable("productsCache1")
  public List<Product> findAllProducts() {
    List<Product> products = productService.getAllProducts();
    //System.out.println("==jagan in cache products1 ==");

    for (Product product : products) {
      Unit unit = productService.getUnitById(product.getUnitId());
      Category category = productService.getCategoryById(
        product.getCategoryId()
      );
//      Brand brand = productService.getBrandById(product.getBrandId());
      Weight weight = productService.getWeightById(product.getWeightId());

      product.setUnitName(unit.getUnitName());
      product.setCategoryName(category.getCategoryName());
//      product.setBrandName(brand.getBrandName());
      product.setWeightUnitName(weight.getWeightName());
    }

    return products;
  }

  @GetMapping("/getAllProductsPage")
  //@Cacheable("products1")
  // @Cacheable("productsCache1")
  public Page<Product> findAllProductsPage(
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "6") int size
  ) {
    Page<Product> products = productService.getAllProductsPage(page, size);
    for (Product product : products) {
      Unit unit = productService.getUnitById(product.getUnitId());
      Category category = productService.getCategoryById(
        product.getCategoryId()
      );
      Brand brand = productService.getBrandById(product.getBrandId());
      Weight weight = productService.getWeightById(product.getWeightId());

      product.setUnitName(unit.getUnitName());
      product.setCategoryName(category.getCategoryName());
      product.setBrandName(brand.getBrandName());
      product.setWeightUnitName(weight.getWeightName());
    }

    return products;
  }

  /*
   * @PostMapping(value="/addProduct" , consumes = MediaType.IMAGE_JPEG_VALUE)
   * public Product addProduct(@RequestBody Product product ) {
   * //System.out.println("adduser"+user.getFirstName()); return
   * productService.addProduct(product); }
   */
  // multipart/form-data'

  // @PostMapping(value = "/new")
  // public Product addProduct(@RequestParam("packagingType") String
  // packagingType,
  // @RequestParam("image") MultipartFile image,
  // @RequestParam("imageType") String imageType) throws IOException {
  // System.out.println("add product");
  // Product product = new Product();
  // product.setPacking_type(packagingType);
  // product.setImage(image.getBytes());
  // product.setImageType(imageType);
  // return productService.addProduct(product);
  // }

  // @PostMapping("/new")
  @PostMapping(value = "/new", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public Product addProduct(
    @RequestParam("product") String product,
    @RequestParam(value = "image", required = false) MultipartFile image
  ) {
    ObjectMapper obj = new ObjectMapper();
    Product newProduct = new Product();
    try {
      newProduct = obj.readValue(product, Product.class);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (product != null) {
      newProduct = productService.addProduct(newProduct);
      String fileName = image.getOriginalFilename();
      try {
        image.transferTo(
          new File("D:\\projects\\Github\\velue\\public\\" + fileName)
        );
      } catch (Exception e) {
        return newProduct;
      }
    }
    return newProduct;
  }

  @PostMapping("/new/bulk")
  public List<Product> addProducts(@RequestBody List<Product> productsList) {
    return productService.addProducts(productsList);
  }

  @GetMapping("/search/salesByProducts")
  public List<SalesByProductResponse> salesByProducts(
    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
  ) {
    return productService.getSalesByProduct(startDate, endDate);
  }

  @GetMapping("/{searchParameter}")
  public List<Product> getProduct(
    @PathVariable String searchParameter,
    @RequestParam VelueConstants.ProductSearchType productSearchType
  ) {
    List<Product> products = new ArrayList<>();

    if (productSearchType == VelueConstants.ProductSearchType.PRODUCT_ID) {
      products = productService.getProductsByItemCode(searchParameter);
    }
    // } else {
    //   product = productService.getProductByName(searchParameter);
    // }

    for (Product product : products) {
      Unit unit = productService.getUnitById(product.getUnitId());
      Category category = productService.getCategoryById(
        product.getCategoryId()
      );
      Brand brand = productService.getBrandById(product.getBrandId());
      Weight weight = productService.getWeightById(product.getWeightId());

      product.setUnitName(unit.getUnitName());
      product.setCategoryName(category.getCategoryName());
      product.setBrandName(brand.getBrandName());
      product.setWeightUnitName(weight.getWeightName());
    }
    return products;
  }

  @GetMapping("/searchByBrandAndCategory")
  public List<Product> searchByBrandAndCategory(
    @RequestParam Long brandId,
    @RequestParam Long categoryId
  ) {
    List<Product> filteredProducts = productService.getProductByBrandAndCategory(
      brandId,
      categoryId
    );

    for (Product product : filteredProducts) {
      Unit unit = productService.getUnitById(product.getUnitId());
      Category category = productService.getCategoryById(
        product.getCategoryId()
      );
      Brand brand = productService.getBrandById(product.getBrandId());
      Weight weight = productService.getWeightById(product.getWeightId());

      product.setUnitName(unit.getUnitName());
      product.setCategoryName(category.getCategoryName());
      product.setBrandName(brand.getBrandName());
      product.setWeightUnitName(weight.getWeightName());
    }

    return filteredProducts;
  }

 
  // @PutMapping("/update/{id}")
  // public Product updateProduct(
  //   @PathVariable Long id,
  //   @RequestBody Product product
  // ) {
  //   return productService.updateProduct(id, product);
  // }

  @PutMapping(
    value = "/update/{id}",
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE
  )
  public Product updateProduct(
    @PathVariable Long id,
    @RequestParam("product") String product,
    @RequestParam(value = "image", required = false) MultipartFile image
  ) {
    ObjectMapper obj = new ObjectMapper();
    Product newProduct = new Product();
    try {
      newProduct = obj.readValue(product, Product.class);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (product != null) {
      newProduct = productService.updateProduct(id, newProduct);
      if (image != null) {
        String fileName = image.getOriginalFilename();
        try {
          image.transferTo(
            new File("D:\\projects\\Github\\velue\\public\\" + fileName)
          );
        } catch (Exception e) {
          return newProduct;
        }
      }
    }
    return newProduct;
  }

  @PatchMapping("/update/{id}/{status}")
  public Product updateStatus(
    @PathVariable Long id,
    @PathVariable String status
  ) {
    return productService.updateProductStatus(id, status);
  }

  // public Category getAllCategory(){
  // return category
  // }
  @GetMapping("/getAllBrand")
  public List<Brand> getAllBrand() {
    return productService.getAllBrand();
  }

  @GetMapping("/getAllCategory")
  public List<Category> getAllCategory() {
    return productService.getAllCategory();
  }

  @GetMapping("/getAllUnits")
  public List<Unit> getAllUnits() {
    return productService.getAllUnits();
  }

  @GetMapping("/getAllWeights")
  public List<Weight> getAllWeights() {
    return productService.getAllWeights();
  }

  @GetMapping("/getAllPackaging")
  public List<Packaging> findAllPackaging() {
    return productService.getAllPackaging();
  }

  // @GetMapping("/getAllAuthorisedBrands")
  // public List<Packaging> findAllPackaging() {
  //   return productService.getAllPackaging();
  // }

  // @PostMapping("/brand/new/")
  @PostMapping(
    value = "/brand/new/",
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE
  )
  public Brand addNewBrand(
    @RequestParam("brand") String brand,
    @RequestParam(value = "image", required = false) MultipartFile image
  ) {
    ObjectMapper obj = new ObjectMapper();
    Brand newBrand = new Brand();

    try {
      newBrand = obj.readValue(brand, Brand.class);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (brand != null) {
      newBrand = productService.addNewBrand(newBrand);
      try {
        if (image != null) {
          String fileName = image.getOriginalFilename();

          image.transferTo(
            new File("D:\\projects\\Github\\velue\\public\\" + fileName)
          );
        }
      } catch (Exception e) {
        return newBrand;
      }
    }
    return newBrand;
  }

  @PutMapping(
    value = "/brand/update/",
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE
  )
  public Brand updateBrand(
    @RequestParam("brand") String brand,
    @RequestParam(value = "image", required = false) MultipartFile image
  ) {
    ObjectMapper obj = new ObjectMapper();
    Brand newBrand = new Brand();

    try {
      newBrand = obj.readValue(brand, Brand.class);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (brand != null) {
      newBrand = productService.updateBrand(newBrand);
      try {
        if (image != null) {
          String fileName = image.getOriginalFilename();

          image.transferTo(
            new File("D:\\projects\\Github\\velue\\public\\" + fileName)
          );
        }
      } catch (Exception e) {
        return newBrand;
      }
    }
    return newBrand;
  }
//START JAGAN
  // @PostMapping("/brand/new/")
  @PostMapping(
    value = "/category/new1/",
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE
  )
  public Category addNewCategory(
    @RequestParam("brand") String category,
    @RequestParam(value = "image", required = false) MultipartFile image
  ) {
    ObjectMapper obj = new ObjectMapper();
    Category newCategory = new Category();

    try {
    	newCategory = obj.readValue(category, Category.class);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (category != null) {
      newCategory = productService.addNewCategory(newCategory);
      try {
        if (image != null) {
          String fileName = image.getOriginalFilename();

          image.transferTo(
            new File("D:\\projects\\Github\\velue\\public\\" + fileName)
          );
        }
      } catch (Exception e) {
        return newCategory;
      }
    }
    return newCategory;
  }

  @PutMapping(
		    value = "/category/update1/",
		    consumes = MediaType.MULTIPART_FORM_DATA_VALUE
		  )
		  public Category updateCategory(
		    @RequestParam("category") String category,
		    @RequestParam(value = "image", required = false) MultipartFile image
		  ) {
		    ObjectMapper obj = new ObjectMapper();
		    Category newCategory = new Category();

		    try {
		      newCategory = obj.readValue(category, Category.class);
		    } catch (JsonProcessingException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    if (category != null) {
		      newCategory= productService.updateCategory(newCategory);
		      try {
		        if (image != null) {
		          String fileName = image.getOriginalFilename();

		          image.transferTo(
		            new File("D:\\projects\\Github\\velue\\public\\" + fileName)
		          );
		        }
		      } catch (Exception e) {
		        return newCategory;
		      }
		    }
		    return newCategory;
		  }

  //END JAGAN
  @PostMapping("/category/new/")
  public Category addNewCategory(@RequestBody Category category) {
    return productService.addNewCategory(category);
  }

  @PutMapping("/category/update/")
  public Category updateCategory(@RequestBody Category category) {
    return productService.updateCategory(category);
  }

  @PostMapping("/unit/new/")
  public Unit addNewUnit(@RequestBody Unit unit) {
    return productService.addNewUnit(unit);
  }

  @PutMapping("/unit/update/")
  public Unit updateUnit(@RequestBody Unit unit) {
    return productService.updateUnit(unit);
  }

  @PostMapping("/packaging/new/")
  public Packaging addNewPackaging(@RequestBody Packaging packaging) {
    return productService.addNewPackaging(packaging);
  }

  @PutMapping("/packaging/update/")
  public Packaging updatePackaging(@RequestBody Packaging packaging) {
    return productService.updatePackaging(packaging);
  }

  @DeleteMapping("brand/delete/{id}")
  public void deleteBrand(@PathVariable Long id) {
    productService.deleteBrand(id);
  }

  @DeleteMapping("category/delete/{id}")
  public void deleteCategory(@PathVariable Long id) {
    productService.deleteCategory(id);
  }

  @DeleteMapping("unit/delete/{id}")
  public void deleteUnit(@PathVariable Long id) {
    productService.deleteUnit(id);
  }

  @DeleteMapping("packaging/delete/{id}")
  public void deletePackaging(@PathVariable Long id) {
    productService.deletePackaging(id);
  }

  @PostMapping("/uploadimg")
  public ResponseEntity<?> handleFileUpload(
    @RequestParam("file") MultipartFile file
  ) {
    String fileName = file.getOriginalFilename();
    try {
      file.transferTo(new File("D:\\test\\" + fileName));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    return ResponseEntity.ok("File uploaded successfully.");
  }
}

