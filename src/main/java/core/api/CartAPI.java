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

    // Gets all Products
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


    @RequestMapping(value = "/cartItems/add/{userId}", method = RequestMethod.POST)
    //@PostMapping(path = "/cartItems/add/{userId}", consumes = "application/json")
    public void addCartItem(@RequestBody Cart cartItem,@PathVariable("userId") int userId) {
        
        cartService.addCartItem(cartItem,userId);

    
    }

    @RequestMapping(value = "/savedItems/add/{userId}", method = RequestMethod.POST)
    //@PostMapping(path = "/cartItems/add/{userId}", consumes = "application/json")
    public void addSavedItem(@RequestBody Cart cartItem,@PathVariable("userId") int userId) {
        
        cartService.addSavedItem(cartItem,userId);

    
    }

    @RequestMapping(value = "/cartItems/delete/{userId}", method = RequestMethod.POST)
    //@PostMapping(path = "/cartItems/add/{userId}", consumes = "application/json")
    public void deleteCartItem(@RequestBody Cart cartItem,@PathVariable("userId") int userId) {
        
        cartService.deleteFromCart(cartItem,userId);

    
    }

    
 
}    