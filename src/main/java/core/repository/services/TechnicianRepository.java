package core.repository.services;

import core.model.services.Technician;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Integer> {

    @Query(value = "select * from technician tn where tn.service_id= :service_id ", nativeQuery = true)
	List<Technician> getTechniciansByService(@Param("service_id") int serviceId);


    
}