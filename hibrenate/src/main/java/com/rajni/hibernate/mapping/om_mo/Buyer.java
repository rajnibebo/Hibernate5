/**
 * 
 */
package com.rajni.hibernate.mapping.om_mo;

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
@Table(name = "TBL_BUYER")
public class Buyer {
	@Id
	@GeneratedValue
	@Column(name = "BUYER_ID")
	private Long buyerID;
	@Column(name = "BUYER_NAME")
	private String buyerName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "buyer")
	private Set<Product> boughtItems = new HashSet<Product>();

	public Long getBuyerID() {
		return buyerID;
	}

	public void setBuyerID(Long buyerID) {
		this.buyerID = buyerID;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public Set<Product> getBoughtItems() {
		return boughtItems;
	}

	public void setBoughtItems(Set<Product> boughtItems) {
		this.boughtItems = boughtItems;
	}

	public void addBoughtItem(Product product) {
		this.boughtItems.add(product);
		product.setBuyer(this);
	}
}
