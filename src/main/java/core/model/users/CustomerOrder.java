package core.model.users;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
 * Order
 */
@Entity
public class CustomerOrder {

    @Autowired
    @Transient
    ProductRepository productRepository;

    @EmbeddedId
    private OrderId orderId;

    @ManyToOne
    @JoinColumn
    private Vendor vendor;
    
    @ManyToOne
    @JoinColumn
    private Customer customer;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    @ManyToOne
    @JoinColumn
    private Product product;

    private Double price;

    private int quantity;

    public CustomerOrder(int id, Customer customer, Vendor vendor, Product product, Double price, int quantity, Date date) {
        this.orderId = new OrderId(customer, date); // Get date from frontend when user checks out the cart
        this.vendor = vendor;
        this.customer = customer;
        this.product = product;
        this.price = productRepository.getPrice(product.getId(), vendor.getId());
        this.quantity = quantity;
        this.timeStamp = date;
    }
}