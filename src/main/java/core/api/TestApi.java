package core.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	// Add product using POST parameters from Angular
	@PostMapping(path = "/products/add")
	public @ResponseBody String addNewProduct(@RequestParam String productName, @RequestParam String productDescription,
			@RequestParam String productCategory, @RequestParam Double productMrp,
			@RequestParam String productImageUrl) {
		Product product = new Product();
		product.setProductName(productName);
		product.setProductDescription(productDescription);
		product.setProductCategory(productCategory);
		product.setProductMrp(productMrp);
		product.setProductImageUrl(productImageUrl);
		return "Added new Product";
	}

	// Gets all product entities as JSON
	@GetMapping(path = "/products")
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
