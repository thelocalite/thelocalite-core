package core.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import core.model.Product;
import core.service.ProductService;
import core.service.TestService;

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

	// Test API to get all product entities as JSON
	@GetMapping(path = "/products")
	public @ResponseBody List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

}
