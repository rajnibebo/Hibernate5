/**
 * 
 */
package com.rajni.hibernate.collection;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
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
@Table(name = "TBL_BID")
public class Bid {
	@Id
	@GeneratedValue
	@Column(name = "BID_ID")
	private Long bidID;
	@Column(name = "BID_AMOUNT")
	private BigDecimal bidAmount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ITEM_ID")
	private CartItem item;

	public Long getBidID() {
		return bidID;
	}

	public void setBidID(Long bidID) {
		this.bidID = bidID;
	}

	public BigDecimal getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(BigDecimal bidAmount) {
		this.bidAmount = bidAmount;
	}

	public CartItem getItem() {
		return item;
	}

	public void setItem(CartItem item) {
		this.item = item;
	}

}
