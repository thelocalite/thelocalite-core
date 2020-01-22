package core.model_backup;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ServicePerson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long servicePersonId;

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean isActive;
	private String imageUrl;
	private String address;
	private String phoneNumber;

	private Double rating;

	@ManyToOne
	@JoinColumn(name = "service_id")
	private Service service;

	// Default Constructor
	public ServicePerson() {
	}

	// Getters & Setters
	public Long getServicePersonId() {
		return servicePersonId;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public void setServicePersonId(Long servicePersonId) {
		this.servicePersonId = servicePersonId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
