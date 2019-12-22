package commons.entities;
import javax.persistence.Embeddable;

@Embeddable
class Item{
	
	private long productId;
	private Double price;
	private Integer quantity;
	
	
	public Item() {
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}