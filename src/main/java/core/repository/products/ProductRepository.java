package core.repository.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import core.model.products.Product;
import core.model.products.ProductVendor;

/**
 * ProductRepository
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // TO DELETE
    void getProductByName(String product);


    // ALSO TO DELETE AFTER ALTERNATIVE

    // Aditya:  "Think about the efficiency!!! "
    @Query(value = "select * from product_vendor pv where pv.vendor_id = :vendorId, pv.product_id = :productId ", nativeQuery = true)
	ProductVendor getPrice(@Param("productId") int productId, @Param("vendorId") int vendorId);


}