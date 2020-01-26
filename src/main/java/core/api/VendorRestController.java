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
@RequestMapping("/vendor")
public class VendorRestController {

    @Autowired
    ProductVendorService productVendorService;

    // Gets all Products
    @GetMapping("")
    List<Vendor> getAllVendors() {
        return productVendorService.getAllVendors();
    }

    // Gets all vendors which provide a product
    @GetMapping("/product/{productId}")
    List<Vendor> getAllVendorsOfAProduct(@PathVariable("productId") int productId) {

        // Gets an instance of the product from the product ID
        Product product = productVendorService.getProductById(productId);

        // Creates empty list to populate
        List<Vendor> vendors = new ArrayList<>();

        // Get the ProductVendors set for the product
        Set<ProductVendor> productVendors = product.getProductVendors();

        // Populate the empty vendors list with all vendors for that product
        for (ProductVendor productVendor : productVendors) {
            vendors.add(productVendor.getVendor());
        }

        // Return our populated vendors list! :D
        return vendors;
    }
}