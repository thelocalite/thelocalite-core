package core.model_backup;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class _Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long orderGroupId;

	private Double rating;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Customer customer;

	// @ManyToOne(cascade=CascadeType.ALL)
	// @JoinColumn(name="vendor_id")
	// private Vendor vendor;

	@OneToOne
	private ProductVendor productVendor;

	private Integer quantity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_detail_id")
	private OrderDetail orderDetail;

	public _Order() {
		// TODO Auto-generated constructor stub
	}

	// Getters & Setters
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Long getOrderGroupId() {
		return orderGroupId;
	}

	public void setOrderGroupId(Long orderGroupId) {
		this.orderGroupId = orderGroupId;
	}

	// public Vendor getVendor() {
	// return vendor;
	// }
	//
	//
	// public void setVendor(Vendor vendor) {
	// this.vendor = vendor;
	// }

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ProductVendor getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(ProductVendor productVendor) {
		this.productVendor = productVendor;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
