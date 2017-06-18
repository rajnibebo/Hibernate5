/**
 * 
 */
package com.rajni.hibernate.mapping.onetoone;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name = "TBL_ITEM")
public class Item {
	@Id
	@GeneratedValue
	@Column(name = "ITEM_ID")
	private Long itemID;
	@Column(name = "ITEM_NAME")
	private String itemName;
	@Column(name = "ITEM_PRICE")
	private BigDecimal itemPrice;
	@OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
	private Shipment shipment;

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

}
