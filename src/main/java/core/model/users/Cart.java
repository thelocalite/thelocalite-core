package core.model.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import core.model.products.Product;
import core.model.products.Vendor;
import core.repository.products.ProductRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
/**
 * Cart
 */
@Entity
public class Cart {

    @Autowired
    @Transient
    ProductRepository productRepository;

    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // ToDo map to User
    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private Customer customer;


    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private Vendor vendor;

    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private Product product;
    
    @Transient
    private Double price;
    
    @Getter @Setter
    private int quantity;

    @Getter @Setter
    private boolean savedForLater;

    public Cart(int id, Customer customer, Vendor vendor, Product product, int quantity) {
        this.customer = customer;
        this.vendor = vendor;
        this.product = product;
        this.quantity = quantity;
        this.savedForLater = false;
    }
    

    public Double getPrice() {
        return productRepository.getPrice(product.getId(), vendor.getId()).getVendorSpecificPrice();
    }
    

}