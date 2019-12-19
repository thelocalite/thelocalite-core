package core.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import core.entities.Actors.Customer;
import core.entities.Actors.Merchant;

@Entity
public class _Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long orderId;
	
	private String status; // DELIVERED / INPROGRESS / CANCELLED
	
	@ElementCollection
	@CollectionTable
	private List<Item> items;
	
	private double rating;
	
//	private long merchantId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="merchantId")
	private Merchant merchant;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customerId")
	private Customer customer;
	
	
//	private long customerId;
	
	private LocalDateTime timestamp;
	
	// Useless crap beneath
	
	public _Order() {
		// TODO Auto-generated constructor stub
	}

	public _Order(String status, List<Item> items, double rating, Merchant merchant, Customer customer,
			LocalDateTime timestamp) {
		super();
		this.status = status;
		this.items = items;
		this.rating = rating;
		this.merchant = merchant;
		this.customer = customer;
		this.timestamp = timestamp;
	}

	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


//	public long getMerchantId() {
//		return merchantId;
//	}
//
//
//	public void setMerchantId(long merchantId) {
//		this.merchantId = merchantId;
//	}
//
//
//	public long getCustomerId() {
//		return customerId;
//	}
//
//
//	public void setCustomerId(long customerId) {
//		this.customerId = customerId;
//	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}


	public Merchant getMerchant() {
		return merchant;
	}


	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	} 
	
	

	
}

