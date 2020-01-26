package core.model.products;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
/**
 * Product
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String brand;
    private String category;
    private String description;
    private Double mrp;
    private String imageUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductVendor> productVendors = new HashSet<>();

    // Args Constructor
    public Product(String name, String brand, String category, String description, Double mrp, String imageUrl) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.description = description;
        this.mrp = mrp;
        this.imageUrl = imageUrl;
    }

    public void addProductVendor(ProductVendor productVendor) {
        this.productVendors.add(productVendor);
    }

    public void removeProductVendor(ProductVendor productVendor) {
        this.productVendors.remove(productVendor);
    }

}