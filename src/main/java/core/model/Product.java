package core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String description;
	private String imgUrl;
	

	@OneToMany(mappedBy = "product")
    private Set<ProductVendor> productVendors = new HashSet<>();
	
	// BS Beneath
	public Product() {
		// TODO Auto-generated constructor stub
	}


	public Product(String name) {
		super();
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public Set<ProductVendor> getProductVendors() {
		return productVendors;
	}


	public void setProductVendors(Set<ProductVendor> productVendors) {
		this.productVendors = productVendors;
	}
	
	


}
