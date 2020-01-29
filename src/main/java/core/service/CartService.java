package core.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.model.users.Cart;
import core.model.users.Customer;
import core.repository.users.CartRepository;
import core.repository.users.CustomerRepository;
import core.repository.products.ProductRepository;

/**
 * CartService
 */
@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired 
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

     // Gets all CartItems
     public Customer getAllCartItems(int id) {
        //List<Cart> cartItems = new ArrayList<>();

        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent())
          return customerOptional.get();
        else
          return new Customer();  


        //---using cartRepository causes a recursive call to customer and to customers set of cartItems
        //  cartItems = cartRepository.findAll();
        // for (Cart cartItem : cartItems) {
        //     Double price = cartItem.getPrice();
        //     cartItem.setPrice(price);
           
        // }


        // return cartItems;
    }

    public Double getNewPrice(Cart cartItem){
        return productRepository.getPrice(cartItem.getProduct().getId(), cartItem.getVendor().getId());
    }
    
}