package core.repository.products;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import core.model.products.Product;


/**
 * ProductRepository
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // TO DELETE
    void getProductByName(String product);


    // ALSO TO DELETE AFTER ALTERNATIVE

    // Aditya:  "Think about the efficiency!!! "
    @Query(value = "select vendor_specific_price from product_vendor pv where pv.vendor_id = :vendorId and pv.product_id = :productId ", nativeQuery = true)
	Double getPrice(@Param("productId") int productId, @Param("vendorId") int vendorId);


    // Gets all distinct categories
    @Query(value = "select distinct category from product p", nativeQuery = true)
	List<String> getAllProductCategories();


}