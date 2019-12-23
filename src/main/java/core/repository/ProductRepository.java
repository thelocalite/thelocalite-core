package core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import core.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	
	@Query(value = "SELECT * FROM product p WHERE p.name = :prodName", 
			  nativeQuery = true)
	public List<Product> getProductsByName(@Param("prodName") String prodName);

}

/*
 * Notes
 * @vatadepalli : https://www.baeldung.com/spring-data-jpa-query
 * @vatadepalli : Most of the functionalities may be achieved by using native SQL queries.
 * */