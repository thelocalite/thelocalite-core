package core.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import core.model.products.*;
import core.service.ProductVendorService;

import org.apache.commons.codec.language.Soundex;

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
     * Smart* Search API
     * 
     * Takes in query for product and returns search results
     * 
     * Now Implements Soundex :D
     * 
     * Soundex is an algorithm invented 100 years ago (between 1918-1922) and used
     * to relate similar sounding names
     * 
     * Uses the Apache Commons Codec Library to import the encoding functionality
     * 
     * The Soundex object encodes a string into a Soundex value which is then
     * compared to another string encoded into a Soundex value using the equals()
     * and encode() method
     * 
     * Since the strings in the search term and the product name could be more than
     * one word, we break up the strings into individual words using split() method
     * of String object We iterate through every combination and add the product to
     * the Collection if matched
     * 
     * Another issue was that during the iteration, multiple matches were being
     * found, so the arraylist was being loaded with duplicate product objects. The
     * Solution was to use a Set instead of a List
     * 
     * The API now returns a HashSet instead of an ArrayList
     */

    @GetMapping("/search/{searchTerm}")
    Set<Product> searchProducts(@PathVariable("searchTerm") String searchTerm) {

        // Creates empty list to populate
        Set<Product> products = new HashSet<>();

        // Search Logic
        List<Product> allProducts = productVendorService.getAllProducts();

        // Soundex Logic
        Soundex soundex = new Soundex();
        for (Product product : allProducts) {
            for (String productword : product.getName().split("\\s+")) {
                for (String searchTermword : searchTerm.split("\\s+")) {
                    if (soundex.encode(productword).equals(soundex.encode(searchTermword)))
                        products.add(product);
                }
            }
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