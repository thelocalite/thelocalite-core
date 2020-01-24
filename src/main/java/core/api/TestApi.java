package core.api;

import core.model.Product;
import core.service.ProductService;
import core.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Enable Cross-Origin Resource Sharing for GET request
// https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS
@CrossOrigin

@RestController
@RequestMapping("/")
public class TestApi {

  @Autowired
  TestService testService;

  @Autowired
  ProductService productService;

  @RequestMapping("")
  public String hello() {
    return "{\"message\":\"Hello\"}";
  }

  @RequestMapping("/addProduct/{productName}")
  public void addProduct(@PathVariable("productName") String productName) {
    productService.addProduct(new Product(productName));
  }

  @RequestMapping("deleteProduct/{productName}")
  public void deleteProduct(@PathVariable("productName") String productName) {
    productService.deleteProductByName(productName);
  }
}
