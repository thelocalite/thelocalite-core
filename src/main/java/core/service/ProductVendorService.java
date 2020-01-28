package core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.model.products.*;
import core.repository.products.*;

/**
 * Service Layer for Products and Vendors related service requests
 */
@Service
public class ProductVendorService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    VendorRepository vendorRepository;

    // Gets all Products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Gets all Vendors
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    // Gets Vendor by ID
    public Vendor getVendorById(Integer id) {
        Optional<Vendor> vendorOptional = vendorRepository.findById(id);
        if (vendorOptional.isPresent())
            return vendorOptional.get();
        else
            return new Vendor();
    }

    // Gets Product by ID
    public Product getProductById(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent())
            return productOptional.get();
        else
            return new Product();
    }

    // Saves Product if not null
    public Boolean saveProduct(Product product) {
        if (product != null) {
            productRepository.save(product);
            return true;
        } else
            return false;
    }

    // Saves Vendor if not null
    public Boolean saveVendor(Vendor vendor) {
        if (vendor != null) {
            vendorRepository.save(vendor);
            return true;
        } else
            return false;
    }
}