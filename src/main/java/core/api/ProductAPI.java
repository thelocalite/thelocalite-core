package core.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import core.model.products.*;
import core.service.ProductVendorService;

/**
 * Product Rest API Controller
 */
@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductAPI {

    @Autowired
    ProductVendorService productVendorService;

    // Gets all Products
    @GetMapping("")
    List<Product> getAllProducts() {
        return productVendorService.getAllProducts();
    }

    // Gets Product by ID
    @GetMapping("/{productId}")
    Product getProductById(@PathVariable("productId") int productId) {
        return productVendorService.getProductById(productId);
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

    /**
     * Search API
     * 
     * Takes in query for product and returns search results
     */

    @GetMapping("/search/{searchTerm}")
    List<Product> searchProducts(@PathVariable("searchTerm") String searchTerm) {

        // Creates empty list to populate
        List<Product> products = new ArrayList<>();

        // TODO Search Logic
        List<Product> allProducts = productVendorService.getAllProducts();

        for (Product product : allProducts) {
            if (product.getName().toLowerCase().contains(searchTerm.toLowerCase()))
                products.add(product);
        }

        // Return search result
        return products;
    }

    /**
     * AutoComplete API
     * 
     * Returns a list of all product names for AutoComplete functionality
     */

    @GetMapping("/productNames")
    List<String> getProductNames() {

        // Creates empty list to populate
        List<String> productNames = new ArrayList<>();

        // TODO Get All Product Names

        // Return search result
        return productNames;
    }

}