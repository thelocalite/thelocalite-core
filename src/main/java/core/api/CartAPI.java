package core.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import core.model.users.Cart;
import core.model.users.Customer;
import core.service.CartService;

/**
 * CartAPI
 */
@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartAPI {


    @Autowired
    CartService cartService;

    /**
     * Get all Shopping Cart Items For a specific Customer
     */
    @GetMapping("/cartItems/{customerId}")
    List<Cart> getAllCartProducts(@PathVariable("customerId") int customerId) {

        Customer customer = cartService.getAllCartItems(customerId);
        List<Cart> cartItems = new ArrayList<>();

        Set<Cart> cart = customer.getCartItems();

        for (Cart cartItem : cart) {
            
            if(!(cartItem.isSavedForLater())){
                Double price = cartService.getNewPrice(cartItem);
                cartItem.setPrice(price);
                cartItems.add(cartItem);
            }
                
        }

        return cartItems;

     }

    

    /**
     * Get all Saved For Later Items For a specific Customer
     */
    @GetMapping("/savedItems/{customerId}")
    List<Cart> getAllSavedProducts(@PathVariable("customerId") int customerId) {

        Customer customer = cartService.getAllCartItems(customerId);
        List<Cart> savedItems = new ArrayList<>();

        Set<Cart> cart = customer.getCartItems();

        for (Cart savedItem : cart) {
            
            if(savedItem.isSavedForLater()){
                Double price = cartService.getNewPrice(savedItem);
                savedItem.setPrice(price);
                savedItems.add(savedItem);
            }
                
        }
    
        return savedItems;

    }

    /**
     * 
     * Post Request For Addinng a Shopping Cart Item
     */    
    @RequestMapping(value = "/cartItems/add/{userId}", method = RequestMethod.POST)
    //@PostMapping(path = "/cartItems/add/{userId}", consumes = "application/json")
    public void addCartItem(@RequestBody Cart cartItem,@PathVariable("userId") int userId) {
        
        cartService.addCartItem(cartItem,userId);

    
    }

    /**
     * 
     * Post Request For Addinng a Saved For Later Item
     */ 
    @RequestMapping(value = "/savedItems/add/{userId}", method = RequestMethod.POST)
    //@PostMapping(path = "/cartItems/add/{userId}", consumes = "application/json")
    public void addSavedItem(@RequestBody Cart cartItem,@PathVariable("userId") int userId) {
        
        cartService.addSavedItem(cartItem,userId);

    
    }

    /**
     * 
     * Request For Deleting from the cart table
     * 
     * Could be either a Shopping Cart Item or a Saved For Later Item
     */ 
    @RequestMapping(value = "/cartItems/delete/{userId}", method = RequestMethod.POST)
    //@PostMapping(path = "/cartItems/add/{userId}", consumes = "application/json")
    public void deleteCartItem(@RequestBody Cart cartItem,@PathVariable("userId") int userId) {
        
        cartService.deleteFromCart(cartItem,userId);

    
    }

    
 
}    