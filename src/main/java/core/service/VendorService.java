package core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.model.Product;
import core.model.ProductVendor;
import core.model.Vendor;
import core.repository.ProductRepository;
import core.repository.ProductVendorRepository;
import core.repository.VendorRepository;

@Service
public class VendorService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private VendorRepository vendorRepo;

	@Autowired
	private ProductVendorRepository productVendorRepository;

	// Add ProductVendor
	public void addProductVendor(Product product, Vendor vendor, Double price) {
		ProductVendor productVendor = new ProductVendor(product, vendor, price);
		product.getProductVendors().add(productVendor);
		vendor.getProductVendors().add(productVendor);

		productRepo.save(product);
		vendorRepo.save(vendor);
		productVendorRepository.save(productVendor);
	}

	// Delete ProductVendor
	public void removeProductVendor(Product product, Vendor vendor) {
		// TODO
	}

	// Add new vendor
	public void addProduct(Vendor vendor) {
		vendorRepo.save(vendor);
	}

	// Delete a vendor
	public void removeProduct(Vendor vendor) {
		vendorRepo.delete(vendor);
	}

	// Add a list of vendors
	public void addProducts(List<Vendor> vendors) {
		vendorRepo.saveAll(vendors);
	}

	// Delete a list of vendors
	public void deleteProducts(List<Vendor> vendors) {
		vendorRepo.deleteAll(vendors);
	}

}