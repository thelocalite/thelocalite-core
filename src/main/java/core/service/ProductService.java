package core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.model.Product;
import core.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

	// Get product list
	public List<Product> getAllProducts() {
		return productRepo.getAllProducts();
	}

	// Add new product
	public void addProduct(Product product) {
		productRepo.save(product);
	}

	// Delete product by name
	public void deleteProductByName(String name) {
		productRepo.deleteAll(productRepo.getProductsByName(name));
	}

	// Delete a product
	public void deleteProduct(Product product) {
		productRepo.delete(product);
	}

	// Add a list of products
	public void addProducts(List<Product> products) {
		productRepo.saveAll(products);
	}

	// Delete a list of products
	public void deleteProducts(List<Product> products) {
		productRepo.deleteAll(products);
	}
}