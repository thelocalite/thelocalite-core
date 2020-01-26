package core.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import core.model.products.*;
import core.service.ProductVendorService;

/**
 * Product Rest API Controller
 */
@RestController
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    ProductVendorService productVendorService;

    // Gets all Products
    @GetMapping("")
    List<Product> getAllProducts() {
        return productVendorService.getAllProducts();
    }

    // Gets all products for a vendor
    @GetMapping("/vendor/{vendorId}")
    List<Product> getAllProductsOfAVendor(@PathVariable("vendorId") int vendorId) {

        // Gets an instance of the vendor from the vendor ID
        Vendor vendor = productVendorService.getVendorById(vendorId);

        // Creates empty list to populate
        List<Product> products = new ArrayList<>();

        // Get the ProductVendors set for the vendor
        Set<ProductVendor> productVendors = vendor.getProductVendors();

        // Populate the empty products list with all products for that vendor
        for (ProductVendor productVendor : productVendors) {
            products.add(productVendor.getProduct());
        }

        // Return our populated products list! :D
        return products;
    }

}