package core.model.users;

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


    @JsonIgnore
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

    @JsonIgnore
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

    

    // public Double getNewPrice() {
    //     return productRepository.getPrice(this.product.getId(), this.vendor.getId()).getVendorSpecificPrice();
    // }
    
    // public void setPrice(){
    //      this.price =  product.getMrp();
    // }


    @Override
    public String toString() {
        return "{" +
            ", id='" + getId() + "'" +
            ", product='" + getProduct() + "'" +
            ", price='" + getPrice() + "'" +
            ", quantity='" + getQuantity() + "'" +
           
            "}";
    }


}