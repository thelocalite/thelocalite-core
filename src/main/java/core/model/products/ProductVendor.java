package core.model.products;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
/**
 * ProductVendor
 */
@Entity
@Table(name = "product_vendor")
public class ProductVendor implements Serializable {
    /**
    *
    */
    @Transient
    private static final long serialVersionUID = 8220609632633982722L;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    private Double vendorSpecificPrice;

}