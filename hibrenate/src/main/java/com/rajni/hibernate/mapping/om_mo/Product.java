/**
 * 
 */
package com.rajni.hibernate.mapping.om_mo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name = "TBL_PRODUCT")
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID")
	private Long productID;
	@Column(name = "PRODUCT_NAME")
	private String productName;
	@Column(name = "PRODUCT_PRICE")
	private BigDecimal initialPrice;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "PRODUCT_ID")
	@OrderColumn(name = "BID_POSITION")
	@ListIndexBase(value = 1)
	private List<Bid> bids = new ArrayList<Bid>();

	@ManyToOne
	@JoinTable(name = "ITEM_BUYER",joinColumns=@JoinColumn(name = "ITEM_ID"),inverseJoinColumns=@JoinColumn(name = "BUYER_ID"))
	private Buyer buyer;
	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(BigDecimal initialPrice) {
		this.initialPrice = initialPrice;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
	public void addBid(Bid bid) {
		bids.add(bid);
		bid.setProduct(this);
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
}
