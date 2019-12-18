package core.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long user_id;
	
	private String userName;
	
	private String email;
	
	private String password;
	
	private long aadharCard;
	
	@ElementCollection
	private List<Long> cart = new ArrayList<Long>();
	
	private ArrayList<Order_> orders;
	
	private String role;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String email, String password, long aadharCard, ArrayList<Long> cart,
			ArrayList<Order_> orders, String role) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.aadharCard = aadharCard;
		this.cart = cart;
		this.orders = orders;
		this.role = role;
	}



	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(long aadharCard) {
		this.aadharCard = aadharCard;
	}

	public List<Long> getCart() {
		return cart;
	}

	public void setCart(List<Long> cart) {
		this.cart = cart;
	}

	public ArrayList<Order_> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order_> orders) {
		this.orders = orders;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
