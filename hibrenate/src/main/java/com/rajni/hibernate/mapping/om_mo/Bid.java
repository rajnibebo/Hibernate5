/**
 * 
 */
package com.rajni.hibernate.mapping.om_mo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name = "TBL_BID_1")
public class Bid {
	@Id
	@GeneratedValue
	@Column(name = "BID_ID")
	private Long bidID;
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID",insertable = false, updatable = false)
	private Product product;
	@Column(name = "BID_AMOUNT")
	private BigDecimal bidAmount;
	public Long getBidID() {
		return bidID;
	}
	public void setBidID(Long bidID) {
		this.bidID = bidID;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public BigDecimal getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(BigDecimal bidAmount) {
		this.bidAmount = bidAmount;
	}
	
}
