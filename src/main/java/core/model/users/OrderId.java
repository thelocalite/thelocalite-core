package core.model.users;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn
    private Customer keyCustomer;

    @Temporal(TemporalType.TIMESTAMP)
    private Date keyOrderTimeStamp;

    public OrderId(Customer customer, Date orderTimeStamp) {
        this.keyCustomer = customer;
        this.keyOrderTimeStamp = orderTimeStamp;
    }
}