package core.model.users;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * OrderId
 */
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
@SuppressWarnings("serial")
public class OrderId implements Serializable {
    @OneToOne
    @JoinColumn
    private Customer customer;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTimeStamp;

    public OrderId(Customer customer, Date orderTimeStamp) {
        this.customer = customer;
        this.orderTimeStamp = orderTimeStamp;
    }
}