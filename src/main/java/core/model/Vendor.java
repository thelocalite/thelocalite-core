package core.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	
	@ManyToMany(mappedBy = "vendors")
	private List<Product> products = new ArrayList<>();
	
	public Vendor() {
	}
	
	public Vendor(String firstName) {
		super();
		this.firstName = firstName;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setId(Long vendorId) {
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	// Helper
	
	public void addProduct(Product product) {
		this.products.add(product);
		product.getVendors().add(this);
	}
	
	public void removeProduct(Product product) {
		this.products.add(product);
		product.getVendors().remove(this);
	}

}
