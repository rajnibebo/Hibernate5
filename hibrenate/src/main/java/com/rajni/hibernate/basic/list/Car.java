/**
 * 
 */
package com.rajni.hibernate.basic.list;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name = "TBL_CAR")
public class Car {
	@Id
	@GeneratedValue
	@Column(name = "CAR_ID")
	private Long carID;
	@Column(name = "CAR_NAME")
	private String name;
	@Column(name = "CAR_COLOR")
	private String color;

	public Long getCarID() {
		return carID;
	}

	public void setCarID(Long carID) {
		this.carID = carID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
