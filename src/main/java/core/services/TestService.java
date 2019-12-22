package core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.model.Product;
import core.model.Vendor;
import core.repository.ProductRepository;
import core.repository.VendorRepository;

@Service
public class TestService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private VendorRepository vendorRepo;
	
	public void testCrud() {
		
		
		Vendor vendor1 = new Vendor("Vendor 1");
		Vendor vendor2 = new Vendor("Vendor 2");
		Vendor vendor3 = new Vendor("Vendor 3");
		
		Product product1 = new Product("Product 1");
		Product product2 = new Product("Product 2");
		Product product3 = new Product("Product 3");
		
		vendor1.addProduct(product1);
		vendor1.addProduct(product2);
		vendor2.addProduct(product1);
		vendor3.addProduct(product1);
		vendor3.addProduct(product3);
		
		
		vendorRepo.save(vendor1);
		vendorRepo.save(vendor2);
		vendorRepo.save(vendor3);
		
		productRepo.save(product1);
		productRepo.save(product2);
		productRepo.save(product3);
		
		

	}

}
