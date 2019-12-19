package core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	
	private String name;
	
	private int quantityInStock;
	
	private String imageUrl;
	
	private String description;
	
	private String category;
	
	public Product() {
	}

	public Product(String name, int quantityInStock, String imageUrl, String description, String category) {
		super();
		this.name = name;
		this.quantityInStock = quantityInStock;
		this.imageUrl = imageUrl;
		this.description = description;
		this.category = category;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int isInStock() {
		return quantityInStock;
	}

	public void setInStock(int inStock) {
		this.quantityInStock = inStock;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
		

}
