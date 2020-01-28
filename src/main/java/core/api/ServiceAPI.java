package core.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import core.model.services.Service;
import core.model.services.Technician;
import core.service.ServiceService;

@CrossOrigin
@RestController
@RequestMapping("/services")
public class ServiceAPI{

    @Autowired
    ServiceService serviceService;

    @GetMapping("")
    List<Service> getAllServices() {
        return serviceService.getAllServices();
    }

    @GetMapping("/{serviceId}")
    List<Technician> getAllTechniciansById(@PathVariable("serviceId") int serviceId) {
        return serviceService.getAllTechniciansById(serviceId);
    }


}