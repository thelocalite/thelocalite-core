package core.api;

import core.model.Product;
import core.service.ProductService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Enable Cross-Origin Resource Sharing for GET request
// https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS
@CrossOrigin

@RestController
@RequestMapping("/product")
public class ProductRestController {

  @Autowired ProductService productService;

  // Add product using POST parameters from Angular
  @PostMapping(path = "/add")
  public @ResponseBody String addNewProduct(@RequestBody Product product) {
    Product product1 = new Product();
    product1.setProductName(product.getProductName());
    product1.setProductDescription(product.getProductDescription());
    product1.setProductCategory(product.getProductCategory());
    product1.setProductMrp(product.getProductMrp());
    product1.setProductImageUrl(product.getProductImageUrl());
    product1.setProductBrand(product.getProductBrand());
    productService.addProduct(product1);
    return "{\"message\":\"Added new Product\"}";
  }

  // Gets all product entities as JSON Array
  @GetMapping(path = "")
  public @ResponseBody Iterable<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  // Gets product by id
  @GetMapping(path = "/{id}")
  public @ResponseBody Product getProduct(@PathVariable("id") Long id) {
    Optional<Product> product = productService.getProduct(id);
    if (product.isPresent())
      return product.get();
    else
      return null;
  }
}
