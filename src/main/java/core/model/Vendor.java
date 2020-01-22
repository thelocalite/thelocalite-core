package core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor

@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorId;

    private String vendorName;

    private String vendorDescription;

    private String vendorImageUrl;

    /**
     * Product has many vendors and vendors have many products In order to map this
     * relationship, we create a new entity between them to which both have a one to
     * many relationship This new entity also has additional details that are unique
     * to the combination of product and vendor like discounted pricing
     */

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    private Set<ProductVendor> productVendors = new HashSet<>();

    public Vendor(String name) {
        this.vendorName = name;
    }

}