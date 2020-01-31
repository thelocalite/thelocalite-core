package core.model.users;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;



import core.model.products.Product;
import core.model.products.Vendor;

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

    // @JsonIgnore
    // @Autowired
    // @Transient
    // ProductRepository productRepository;

    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
    @JsonIgnore
    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private Customer customer;


    // @JsonIgnore
    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private Vendor vendor;


    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private Product product;
    
    @Getter
    @Setter
    private Double price;
    
    @Getter @Setter
    private int quantity;

    
    @Getter @Setter
    private boolean savedForLater;

   


    public Cart(int id, Customer customer, Vendor vendor, Product product, Double price,int quantity) {
        this.id = id;
        this.customer = customer;
        this.vendor = vendor;
        this.product = product;
        this.price =  price;
        this.quantity = quantity;
        this.savedForLater = false;
    }

   


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", vendor='" + getVendor() + "'" +
            ", product='" + getProduct() + "'" +
            ", price='" + getPrice() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", savedForLater='" + isSavedForLater() + "'" +
            "}";
    }

    
 

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cart)) {
            return false;
        }
        Cart cart = (Cart) o;
        return this.id == (cart.id) && Objects.equals(customer, cart.customer) && Objects.equals(vendor, cart.vendor) && Objects.equals(product, cart.product) && Objects.equals(price, cart.price) && quantity == cart.quantity && savedForLater == cart.savedForLater;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, vendor, product, price, quantity, savedForLater);
    }
    
  

}
