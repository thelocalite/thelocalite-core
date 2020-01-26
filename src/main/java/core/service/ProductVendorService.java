package core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.model.products.*;
import core.repository.products.*;

@Service
public class ProductVendorService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    VendorRepository vendorRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Vendor getVendorById(Integer id) {
        Optional<Vendor> vendorOptional = vendorRepository.findById(id);
        if (vendorOptional.isPresent())
            return vendorOptional.get();
        else
            return new Vendor();
    }

    public Product getProductById(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent())
            return productOptional.get();
        else
            return new Product();
    }
}