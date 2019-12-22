package core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import core.model.Vendor;

@Repository
public interface VendorRepository extends CrudRepository<Vendor, Long>{

}
