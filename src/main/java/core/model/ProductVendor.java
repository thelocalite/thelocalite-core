package core.model;

import java.io.Serializable;

import javax.persistence.*;
import lombok.*;

/**
 * Generates getters for all fields, a useful toString method, and hashCode and
 * equals implementations that check all non-transient fields. Will also
 * generate setters for all non-final fields, as well as a constructor.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
public class ProductVendor implements Serializable {

    /**
     * Default SerialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productVendorId;

    @ManyToOne
    @JoinColumn
    private Product product;

    @ManyToOne
    @JoinColumn
    private Vendor vendor;

    // vendor specific price for products
    private Double vendorSpecificPrice;

    // If no price is specified, set price as the MRP
    public ProductVendor(Product product, Vendor vendor) {
        this.product = product;
        this.vendor = vendor;
        this.vendorSpecificPrice = product.getProductMrp();
    }

    // If price is specified, set the price as the vendor price
    public ProductVendor(Product product, Vendor vendor, Double price) {
        this.product = product;
        this.vendor = vendor;
        this.vendorSpecificPrice = price;
    }
}