package core.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productId;
	
	private String name;
	private String description;
	private String imgUrl;
	
	@ManyToMany
	@JoinTable(name="Product_Vendor", 
		joinColumns= {@JoinColumn(name="productId")},
		inverseJoinColumns = {@JoinColumn(name="vendorId")})
	private List<Vendor> vendors = new ArrayList<>();
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}


	public Product(String name) {
		super();
		this.name = name;
	}


	public Long getProductId() {
		return productId;
	}


	public void setId(Long productId) {
		this.productId = productId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public List<Vendor> getVendors() {
		return vendors;
	}


	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}
	
}
