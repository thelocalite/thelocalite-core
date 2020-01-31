package core.model.users;

//import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

/**
 * User
 */
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Cart> cartItems;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<CustomerOrder> customerOrder; 

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void addCartItem(Cart cartItem) {
        cartItems.add(cartItem);
        cartItem.setCustomer(this);
    }
 
    public void removeCartItem(Cart cartItem) {
        boolean removed = cartItems.remove(cartItem);
        System.out.println("Removed from set = "+removed);
        cartItem.setCustomer(null);
    }

    @Override
    public String toString() {
        return "Customer [cartItems=" + cartItems + ", customerOrder=" + customerOrder + ", email=" + email + ", id="
                + id + ", name=" + name + "]";
    }

    // @Override
    // public boolean equals(Object o) {
    //     if (o == this)
    //         return true;
    //     if (!(o instanceof Customer)) {
    //         return false;
    //     }
    //     Customer customer = (Customer) o;
    //     return id == customer.id && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(cartItems, customer.cartItems) && Objects.equals(customerOrder, customer.customerOrder);
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(id, name, email, cartItems, customerOrder);
    // }

    

}