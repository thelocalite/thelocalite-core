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
public class Merchant extends User{

	@OneToMany(mappedBy="merchant", cascade=CascadeType.ALL)
	private List<_Order> orders;
	
	@ElementCollection
	@CollectionTable(name="Merchant_Stock", joinColumns = @JoinColumn(name="user_id"))
	private List<Item> stock = new ArrayList<Item>();
	// Need to use List, as ArrayList can't be directly used with the above annotation.
	
	private long gstNumber;
	
	private boolean verified;
	
	private double averageRating;
	
	private String merchantType; // Pharma
	
	
	public Merchant() {
		super();
	}


	public Merchant(ArrayList<_Order> orders, List<Item> stock, long gstNumber, boolean verified, double averageRating,
			String merchantType) {
		super();
		this.orders = orders;
		this.stock = stock;
		this.gstNumber = gstNumber;
		this.verified = verified;
		this.averageRating = averageRating;
		this.merchantType = merchantType;
	}


	public List<_Order> getOrders() {
		return orders;
	}


	public void setOrders(ArrayList<_Order> orders) {
		this.orders = orders;
	}


	public List<Item> getStock() {
		return stock;
	}


	public void setStock(List<Item> stock) {
		this.stock = stock;
	}


	public long getGstNumber() {
		return gstNumber;
	}


	public void setGstNumber(long gstNumber) {
		this.gstNumber = gstNumber;
	}


	public boolean isVerified() {
		return verified;
	}


	public void setVerified(boolean verified) {
		this.verified = verified;
	}


	public double getAverageRating() {
		return averageRating;
	}


	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}


	public String getMerchantType() {
		return merchantType;
	}


	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}
	
	
	
	
}
