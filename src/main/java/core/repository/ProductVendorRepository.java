package core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import core.model.ProductVendor;

@Repository
public interface ProductVendorRepository extends CrudRepository<ProductVendor, Long>{

}
