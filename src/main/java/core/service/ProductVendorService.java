package core.service;

import java.util.List;

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
        return vendorRepository.getOne(id);
    }

    public Product getProductById(Integer id) {
        return productRepository.getOne(id);
    }
}