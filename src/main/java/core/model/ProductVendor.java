package core.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class ProductVendor{
	
	// Composite Key
	@EmbeddedId
	private ProductVendorId id = new ProductVendorId();
	
	@ManyToOne
    @MapsId("productId")
	private Product product;
	
	@ManyToOne
    @MapsId("vendorId")
	private Vendor vendor;
	
	
	public ProductVendor() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ProductVendor(Product product, Vendor vendor) {
		super();
		this.product = product;
		this.vendor = vendor;
	}

	public ProductVendorId getId() {
		return id;
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
	
	
	
}
