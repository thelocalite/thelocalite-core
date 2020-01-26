package core.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import core.model.products.Product;
import core.model.products.Vendor;
import core.repository.products.ProductRepository;
import core.repository.products.VendorRepository;

/**
 * Store
 */
@RestController
@RequestMapping("/store")
public class Store {

    @Autowired
    VendorRepository vendorRepo;

    @Autowired
    ProductRepository productRepo;

    // List all vendors
    @GetMapping("/vendors")
    List<Vendor> getAllVendors() {
        return vendorRepo.findAll();
    }

    // List all products
    @GetMapping("/products")
    List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    // List products of all vendors
    @GetMapping("/vendors/{vendorId}/products")
    List<Vendor> getAllProductsOfAVendor(@PathVariable("vendorId") int vendorId) {
        System.out.println(vendorId);
        return vendorRepo.findAll();
    }

}