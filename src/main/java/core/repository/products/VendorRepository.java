package core.repository.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import core.model.products.Vendor;

/**
 * VendorRepository
 */
@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}