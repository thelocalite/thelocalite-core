package core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
      }

    public Double getNewPrice(Cart cartItem){
        return productRepository.getPrice(cartItem.getProduct().getId(), cartItem.getVendor().getId());
    }
    
    /**
     * Add to Cart API 
     * 
     * 1) When adding a new cartItem into the cart
     * 
     * 2)Adding to cart from 'Saved For Later'
     *      * Which is essentially only changing the 'savedForLater' flag as false,
     *        as it already exists in the cart table;
     */
    public void addCartItem(Cart cartItem,int userId){
      boolean addFlag = false;
      Optional<Customer> customerOptional = customerRepository.findById(userId);
      if (customerOptional.isPresent()){
          Customer customer = customerOptional.get();
          Set<Cart> cart = customer.getCartItems();
          for(Cart item : cart){
            if(item.getId()==cartItem.getId())
            {
              System.out.println("Inside found in cart addFlag=false");
              addFlag = false;
              break;
            }
            else
            {
              System.out.println("Inside found in cart addFlag=true");
              addFlag = true;
            }
          }
          if(addFlag==true)
          {
            
            customer.addCartItem(cartItem);
            customerRepository.save(customer);
          }
          else
          {
            customer.removeCartItem(cartItem);
            customerRepository.save(customer);
            System.out.println("Customer cart items after removal" + customer.getCartItems());
            System.out.println("Cart saved flag = " + cartItem.isSavedForLater());
            cartItem.setSavedForLater(false);
            customer.addCartItem(cartItem);
            customerRepository.save(customer);
          }  
      }
    }
    /**
     * Add to SavedForLater API 
     * 
     * 1) When adding a new savedForLaterItem into the cart
     * 
     * 2)Adding to 'Saved For Later' from cart
     *      * Which is essentially only changing the 'savedForLater' flag as true,
     *        as it already exists in the cart table;
     */


    public void addSavedItem(Cart savedItem,int userId){
      boolean addFlag = false;
      Optional<Customer> customerOptional = customerRepository.findById(userId);
      if (customerOptional.isPresent()){
          Customer customer = customerOptional.get();
          Set<Cart> cart = customer.getCartItems();
          for(Cart item : cart){
            if(item.getId()==savedItem.getId())
            {
              System.out.println("Inside found in cart addFlag=false");
              addFlag = false;
              break;
            }
            else
            {
              System.out.println("Inside found in cart addFlag=true");
              addFlag = true;
            }
          }
          if(addFlag==true)
          {
            
            customer.addCartItem(savedItem);
            customerRepository.save(customer);
          }
          else
          {
            customer.removeCartItem(savedItem);
            customerRepository.save(customer);
            System.out.println("Customer cart items after removal" + customer.getCartItems());
            System.out.println("Cart saved flag = " + savedItem.isSavedForLater());
            savedItem.setSavedForLater(true);
            customer.addCartItem(savedItem);
            customerRepository.save(customer);
          }  
      }
    }

    public void deleteFromCart(Cart cartItem,int userId){
      boolean deleteFlag = false;
      Optional<Customer> customerOptional = customerRepository.findById(userId);
      if (customerOptional.isPresent()){
          Customer customer = customerOptional.get();
          Set<Cart> cart = customer.getCartItems();
          for(Cart item : cart){
            if(item.getId()==cartItem.getId())
            {
              System.out.println("Inside found in cart addFlag=true");
              deleteFlag = true;
              break;
            }
            else
            {
              System.out.println("Inside found in cart addFlag=false");
              
            }
          }
          if(deleteFlag==true){
            System.out.println("Inside delete");
            List<Cart> cartNew = new ArrayList<>();
            for(Cart item : cart){
              if(item.getId()==cartItem.getId()){
                  cartNew.add(item);
             
            }
          } 
            cart.removeAll(cartNew);
            // for(Cart itemNew : cartNew){
            //   if(itemNew.getId()!=cartItem.getId()){
            //       cart.add(itemNew);
             
            // }
          //}
            System.out.println("Cart before saving"+customer.getCartItems());
            customer.setCartItems(cart);
            customerRepository.save(customer);
            System.out.println("Cart after deleting"+customer.getCartItems());
          
      }
    } 
  }

}  

