package core.repository.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import core.model.products.Product;

/**
 * ProductRepository
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}