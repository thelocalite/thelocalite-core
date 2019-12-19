package core.entities.Actors;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import core.entities._Order;

@Entity
public class Customer extends User{

	@ElementCollection
	@CollectionTable(joinColumns = @JoinColumn(name="user_id"))
	private List<Item> cart = new ArrayList<Item>();
	// Need to use List, as ArrayList can't be directly used with the above annotation.
	
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
	private List<_Order> orders;
	
	public Customer() {
		super();
	}
	
	public Customer(ArrayList<Item> cart, ArrayList<_Order> orders) {
		super();
		this.cart = cart;
		this.orders = orders;
	}

	public List<Item> getCart() { 
		return cart;
	}

	public void setCart(ArrayList<Item> cart) {
		this.cart = cart;
	}

	public List<_Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<_Order> orders) {
		this.orders = orders;
	}
	
	
}
