/**
 * 
 */
package com.rajni.hibernate.collection;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name = "CART_ITEM")
public class CartItem {
	@Id
	@GeneratedValue
	@Column(name = "ITEM_ID")
	private Long itemID;
	
	@Column(name = "ITEM_NAME")
	private String name;
	
	@Column(name = "ITEM_PRICE")
	private BigDecimal price;
	
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	private Set<Bid> bids = new HashSet<Bid>();

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	public void addBid(Bid bid) {
		this.bids.add(bid);
		bid.setItem(this);
	}
}
