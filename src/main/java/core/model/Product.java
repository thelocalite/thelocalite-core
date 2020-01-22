package core.model;

import java.util.Set;
import java.util.stream.*;

import javax.persistence.*;
import lombok.*;

/**
 * Generates getters for all fields, a useful toString method, and hashCode and
 * equals implementations that check all non-transient fields. Will also
 * generate setters for all non-final fields, as well as a constructor.
 */
@Data
@NoArgsConstructor

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	private String productName;

	private String productCategory;

	private String productDescription;

	// Default Maximun Retail Price printed on the product
	private Double productMrp;

	private String productImageUrl;

	private String productBrand;

	/**
	 * Product has many vendors and vendors have many products In order to map this
	 * relationship, we create a new entity between them to which both have a one to
	 * many relationship This new entity also has additional details that are unique
	 * to the combination of product and vendor like discounted pricing
	 */

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<ProductVendor> productVendors;

	public Product(String name, ProductVendor... productVendors) {
		this.productName = name;
		for (ProductVendor productVendor : productVendors)
			productVendor.setProduct(this);
		this.productVendors = Stream.of(productVendors).collect(Collectors.toSet());
	}

	public Product(String name) {
		this.productName = name;
	}

}