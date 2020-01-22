package core.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import core.model.Product;
import core.service.ProductService;
import core.service.TestService;

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

	@RequestMapping("/addProduct/{productName}")
	public void addProduct(@PathVariable("productName") String productName) {
		productService.addProduct(new Product(productName));
	}

	@RequestMapping("deleteProduct/{productName}")
	public void deleteProduct(@PathVariable("productName") String productName) {
		productService.deleteProductByName(productName);
	}

	// Add product using POST parameters from Angular
	@PostMapping(path = "/product/add")
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

	// Gets all product entities as JSON
	@GetMapping(path = "/product")
	public @ResponseBody Iterable<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	// Gets product by id
	@GetMapping(path = "/product/{id}")
	public @ResponseBody Product getProduct(@PathVariable("id") Long id) {
		Optional<Product> product = productService.getProduct(id);
		if (product.isPresent())
			return product.get();
		else
			return null;
	}

}
