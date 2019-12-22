package core.model;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long vendorId;
	
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String phoneNumber;
	private String vendorCategory;
	
	
	@OneToMany(mappedBy = "vendor")
    private Set<ProductVendor> productVendors = new HashSet<>();
	
	
	public Vendor() {
	}
	
	public Vendor(String firstName) {
		super();
		this.firstName = firstName;
	}

	public Long getVendorId() {
		return vendorId;
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
