package core.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import core.model.users.Customer;

/**
 * CustomerRepository 
 * */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}