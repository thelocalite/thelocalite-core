package core.model_backup;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class ProductVendorId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long productId;
	private Long vendorId;

	public ProductVendorId() {
		// TODO Auto-generated constructor stub
	}

	public ProductVendorId(Long productId, Long vendorId) {
		super();
		this.productId = productId;
		this.vendorId = vendorId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// TODO Understand WTF this is.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((vendorId == null) ? 0 : vendorId.hashCode());
		return result;
	}

	// TODO Understand WTF this is.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductVendorId other = (ProductVendorId) obj;
		return Objects.equals(getProductId(), other.getProductId())
				&& Objects.equals(getVendorId(), other.getVendorId());
	}

}
