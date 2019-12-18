package core.entities;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order_ {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long order_id;
	
	private String status;
	
	@ElementCollection
	@CollectionTable
	private List<Item> items;
	
	// Useless crap beneath
	
	public Order_() {
		// TODO Auto-generated constructor stub
	}
	

	public Order_(String status, List<Item> items) {
		super();
		this.status = status;
		this.items = items;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	} 

	
}

