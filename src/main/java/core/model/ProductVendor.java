package core.model;

import java.io.Serializable;

import javax.persistence.*;

import core.model.ProductVendor.ProductVendorID;
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

@IdClass(ProductVendorID.class)
@Entity
public class ProductVendor implements Serializable {

    /**
     * Default SerialVersionUID
     */
    private static final long serialVersionUID = 1L;

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long productVendorId;
    @Id
    @ManyToOne
    @JoinColumn
    private Product product;

    @Id
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

    /**
     * When Defining a composite key, it is necessary to have a IDClass This class
     * contains the entities which compose the composite key It also needs to have a
     * parametrized constructor and equals and hashcode overridden
     */
    @EqualsAndHashCode
    public static class ProductVendorID implements Serializable {

        private static final long serialVersionUID = 1L;

        private Vendor vendor;
        private Product product;

        public ProductVendorID() {
        }

        public ProductVendorID(Product product, Vendor vendor) {
            this.product = product;
            this.vendor = vendor;
        }

    }
}