package core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import core.model.services.Service;
import core.model.services.Technician;
import core.repository.services.ServiceRepository;
import core.repository.services.TechnicianRepository;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    TechnicianRepository technicianRepository;

    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public List<Technician> getAllTechniciansById(Integer id) {
        List<Technician> technicians = technicianRepository.getTechniciansByService(id);

        return technicians;
    }
    

}
