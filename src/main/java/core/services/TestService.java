package core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.model.Product;
import core.model.ProductVendor;
import core.model.Vendor;
import core.repository.ProductRepository;
import core.repository.ProductVendorRepository;
import core.repository.VendorRepository;

@Service
public class TestService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private VendorRepository vendorRepo;
	
	@Autowired
	private ProductVendorRepository productVendorRepository;
	
	public void testCrud() {
		
		Product product1 = new Product("Product 1");
		productRepo.save(product1);
		
		Vendor vendor1 = new Vendor("Vendor 1");
		vendorRepo.save(vendor1);
			
		ProductVendor productVendor = new ProductVendor(product1, vendor1);
		
		product1.getProductVendors().add(productVendor);
		vendor1.getProductVendors().add(productVendor);
		productVendorRepository.save(productVendor);
		
	}

}