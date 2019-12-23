/*
 * Notes
 * @vatadepalli: Please read the below resource carefully
 * 				 https://hellokoding.com/jpa-many-to-many-extra-columns-relationship-mapping-example-with-spring-boot-maven-and-mysql/
 * */
package core.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class ProductVendor{
	
	@EmbeddedId
	private ProductVendorId id = new ProductVendorId();
	
	@ManyToOne
    @MapsId("productId")
	private Product product;
	
	@ManyToOne
    @MapsId("vendorId")
	private Vendor vendor;
	
	// Additional Fields
	private Double price;
	private Double discount;
	private Integer quantityInStock;
	
	
	public ProductVendor() {
		// TODO Auto-generated constructor stub
	}

	public ProductVendor(Product product, Vendor vendor, Double price, Double discount) {
		super();
		this.product = product;
		this.vendor = vendor;
		this.price = price;
		this.discount = discount;
	}

	// Getters & Setters
	
	public ProductVendorId getId() {
		return id;
	}

	public Integer getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public void setId(ProductVendorId id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
}
