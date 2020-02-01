package core.model.products;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import core.security.models.Auth;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
/**
 * Vendor
 */
@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private String imageUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "vendor")
    private Set<ProductVendor> productVendors;

    @JsonIgnore
	@OneToOne(mappedBy="vendor", cascade=CascadeType.ALL)
    private Auth auth;

    // Args Constructor

    public Vendor(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

}