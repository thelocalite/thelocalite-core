package core.model_backup;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vendorId;

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean isActive;
	private String imageUrl;
	private String address;
	private String phoneNumber;
	private String vendorCategory;

	// @OneToMany(mappedBy="vendor", cascade = CascadeType.ALL)
	// private List<_Order> orders;

	@OneToMany(mappedBy = "vendor")
	private Set<ProductVendor> productVendors = new HashSet<>();

	// Default Constructor
	public Vendor() {
	}

	// Parameterised Constructor
	public Vendor(String firstName) {
		super();
		this.firstName = firstName;
	}

	// Getters & Setters

	public Long getVendorId() {
		return vendorId;
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

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
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

	public String getVendorCategory() {
		return vendorCategory;
	}

	public void setVendorCategory(String vendorCategory) {
		this.vendorCategory = vendorCategory;
	}

	public Set<ProductVendor> getProductVendors() {
		return productVendors;
	}

	public void setProductVendors(Set<ProductVendor> productVendors) {
		this.productVendors = productVendors;
	}

}
