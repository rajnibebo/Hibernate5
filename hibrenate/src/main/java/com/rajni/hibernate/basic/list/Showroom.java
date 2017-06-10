/**
 * 
 */
package com.rajni.hibernate.basic.list;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name = "CAR_SHOWROOM")
public class Showroom {
	@Id
	@GeneratedValue
	@Column(name = "CAR_SHOWROOM_ID")
	private Long showroomID;
	@Column(name = "SHOWROOM_NAME")
	private String name;
	@Column(name = "SHOWROOM_MANAGER")
	private String manager;
	@JoinTable(name = "CAR_LIST", joinColumns = @JoinColumn(name = "S_ID"), 
			inverseJoinColumns = @JoinColumn(name = "C_ID"))
	private List<Car> cars = new ArrayList<Car>();

	public Long getShowroomID() {
		return showroomID;
	}

	public void setShowroomID(Long showroomID) {
		this.showroomID = showroomID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
