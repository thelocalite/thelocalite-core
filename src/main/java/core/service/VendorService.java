package core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.model.*;
import core.repository.*;

@Service
public class VendorService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private VendorRepository vendorRepo;

	// Gets list of vendors by using repository function
	public Iterable<Vendor> getAllVendors() {
		return vendorRepo.findAll();
	}

	// Gets Product by Id using repository function
	public Optional<Vendor> getVendor(long id) {
		return vendorRepo.findById(id);
	}

	// Delete ProductVendor
	public void removeProductVendor(Product product, Vendor vendor) {
		// TODO
	}

	// Add new vendor
	public void addVendor(Vendor vendor) {
		vendorRepo.save(vendor);
	}

	// Delete a vendor
	public void removeVendor(Vendor vendor) {
		vendorRepo.delete(vendor);
	}

	// Add a list of vendors
	public void addVendors(List<Vendor> vendors) {
		vendorRepo.saveAll(vendors);
	}

	// Delete a list of vendors
	public void deleteVendors(List<Vendor> vendors) {
		vendorRepo.deleteAll(vendors);
	}

}