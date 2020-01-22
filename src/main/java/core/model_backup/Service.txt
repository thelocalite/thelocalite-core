package core.model_backup;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ServiceId;

	private String serviceName;
	private String description;

	@OneToMany(mappedBy = "service")
	private List<ServicePerson> servicePersons;

	// Default Constructor
	public Service() {
	}

	// Getters & Setters
	public Long getServiceId() {
		return ServiceId;
	}

	public void setServiceId(Long serviceId) {
		ServiceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ServicePerson> getServicePersons() {
		return servicePersons;
	}

	public void setServicePersons(List<ServicePerson> servicePersons) {
		this.servicePersons = servicePersons;
	}

}
