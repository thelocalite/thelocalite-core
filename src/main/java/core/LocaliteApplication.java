package core;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import core.model.products.Product;
import core.model.products.ProductVendor;
import core.model.products.Vendor;
import core.repository.products.ProductRepository;
import core.repository.products.VendorRepository;

@SpringBootApplication
public class LocaliteApplication implements CommandLineRunner {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private VendorRepository vendorRepository;

  public static void main(String[] args) {
    SpringApplication.run(LocaliteApplication.class, args);
  }

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    prodTest();
  }

  public void prodTest() {

    Product prodA = new Product("Maggi Atta Noodles", "Nestle", "Foods", "An awesome product by maggi", 20.0,
        "imageUrl");

    Vendor vendor1 = new Vendor("name1", "desc1", "url1");
    Vendor vendor2 = new Vendor("name2", "desc2", "url2");

    ProductVendor prodVendX = new ProductVendor();
    prodVendX.setProduct(prodA);
    prodVendX.setVendor(vendor1);
    prodVendX.setVendorSpecificPrice(20.0);

    prodA.getProductVendors().add(prodVendX);

    ProductVendor prodVendY = new ProductVendor();
    prodVendY.setProduct(prodA);
    prodVendY.setVendor(vendor2);
    prodVendY.setVendorSpecificPrice(110.0);

    prodA.getProductVendors().add(prodVendY);

    vendorRepository.save(vendor1);
    vendorRepository.save(vendor2);
    productRepository.save(prodA);

  }

}
