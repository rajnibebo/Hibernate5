/**
 * 
 */
package com.rajni.hibernate.mapping.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name = "TBL_SHIPMENT")
public class Shipment {
	@Id
	@GeneratedValue
	@Column(name = "SHIPMENT_ID")
	private Long shipmentID;
	@Column(name = "SHIPMENT_NAME")
	private String name;
	@OneToOne
	@JoinTable(name = "ITEM_SHIPMENT", joinColumns = @JoinColumn(name = "SHIPMENT_ID"), inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
	private Item item;

	public Long getShipmentID() {
		return shipmentID;
	}

	public void setShipmentID(Long shipmentID) {
		this.shipmentID = shipmentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
