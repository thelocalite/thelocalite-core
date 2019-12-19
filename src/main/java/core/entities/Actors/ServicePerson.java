package core.entities.Actors;

import javax.persistence.Entity;

@Entity
public class ServicePerson extends User{
	
	private String serviceType;
	
	private Double averageRating;
	
	public ServicePerson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServicePerson(String serviceType, Double averageRating) {
		super();
		this.serviceType = serviceType;
		this.averageRating = averageRating;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

}
