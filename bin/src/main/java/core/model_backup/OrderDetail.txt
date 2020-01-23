package core.model_backup;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private _Order Order;

	private String CurrentStatus;
	private LocalDateTime TimePlaced;
	private LocalDateTime TimeAccepted;
	private LocalDateTime TimeOutForDelivery;
	private LocalDateTime Delivered;

	@OneToOne(mappedBy = "orderDetail", cascade = CascadeType.ALL)
	private _Order order;

	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public _Order getOrder() {
		return Order;
	}

	public void setOrder(_Order order) {
		Order = order;
	}

	public String getCurrentStatus() {
		return CurrentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		CurrentStatus = currentStatus;
	}

	public LocalDateTime getTimePlaced() {
		return TimePlaced;
	}

	public void setTimePlaced(LocalDateTime timePlaced) {
		TimePlaced = timePlaced;
	}

	public LocalDateTime getTimeAccepted() {
		return TimeAccepted;
	}

	public void setTimeAccepted(LocalDateTime timeAccepted) {
		TimeAccepted = timeAccepted;
	}

	public LocalDateTime getTimeOutForDelivery() {
		return TimeOutForDelivery;
	}

	public void setTimeOutForDelivery(LocalDateTime timeOutForDelivery) {
		TimeOutForDelivery = timeOutForDelivery;
	}

	public LocalDateTime getDelivered() {
		return Delivered;
	}

	public void setDelivered(LocalDateTime delivered) {
		Delivered = delivered;
	}

}
