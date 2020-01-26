package core.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import core.model.products.*;
import core.repository.products.*;

/**
 * Test
 */
@RestController
@RequestMapping("/")
public class Test {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private VendorRepository vendorRepository;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public String test() {
    return "{\"message\": \"Hello, World!\"}";
  }

  @GetMapping("/test")
  public String productVendorMappingTest() {
    productVendorApiTest();
    return "{\"message\": \"Hello, Test!\"}";
  }

  /**
   * @technologic808
   * 
   *                 Product Vendor Mapping Test
   * 
   *                 Run this test by going to "localhost:8080"
   * 
   *                 In this test we add two products and two vendors Then we add
   *                 one of the products to one vendor and both of the products to
   *                 the other vendor
   * 
   *                 Once the products are saved, We can try accessing the
   *                 products for a particular vendor through the API
   * 
   *                 "/product/vendor/{vendorId}"
   * 
   *                 This test runs successfully on the current build
   * 
   * 
   *                 Notes: There are still some points to be cleared;
   * 
   *                 1. Why does it fail when you try to save the products first?
   *                 2. Why do you not add the ProductVendor objects to the Set of
   *                 PVs in the vendor entity?
   */
  public void productVendorApiTest() {

    // Adds two products

    Product maggieProduct1 = new Product("Maggie Masala Noodles", "Nestle", "Snacks", "Masala Noodles 70gm", 12.0,
        "maggie-masala.jpg");

    Product maggieProduct2 = new Product("Maggie Atta Noodles", "Nestle", "Snacks", "Atta Noodles 70gm", 15.0,
        "maggie-atta.jpg");

    // Adds two vendors

    Vendor moreVendor = new Vendor("More Store", "Daily Store", "More.jpg");

    Vendor smartStore = new Vendor("Smart Store", "Super Store", "Smart.jpg");

    // Creates the first PV
    ProductVendor pv1 = new ProductVendor();
    pv1.setProduct(maggieProduct1);
    pv1.setVendor(moreVendor);
    pv1.setVendorSpecificPrice(11.0);

    // Adds PV to product's 'many to one' mapping of PVs

    // "Why not add the ProductVendor to the vendors PV set?" you ask...
    // I say that's a really good question!
    // Please let me know if you can find the answer!

    maggieProduct1.getProductVendors().add(pv1);

    // Creates the second PV
    ProductVendor pv2 = new ProductVendor();
    pv2.setProduct(maggieProduct1);
    pv2.setVendor(smartStore);
    pv2.setVendorSpecificPrice(10.0);

    // Adds PV to product's 'many to one' mapping of PVs
    maggieProduct1.getProductVendors().add(pv2);

    // Creates the third PV
    ProductVendor pv3 = new ProductVendor();
    pv3.setProduct(maggieProduct2);
    pv3.setVendor(smartStore);
    pv3.setVendorSpecificPrice(12.0);

    // Adds PV to product's 'many to one' mapping of PVs
    maggieProduct2.getProductVendors().add(pv3);

    // Saves the vendors first (If you try to save the products first, it fails!!)
    vendorRepository.save(moreVendor);
    vendorRepository.save(smartStore);

    // Saves the products once the vendors are safe and saved
    productRepository.save(maggieProduct1);
    productRepository.save(maggieProduct2);

  }

}