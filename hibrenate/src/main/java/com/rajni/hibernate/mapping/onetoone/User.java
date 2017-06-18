/**
 * 
 */
package com.rajni.hibernate.mapping.onetoone;

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
@Table(name = "TBL_CUSTOMER")
public class User {
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Long userID;
	@Column(name = "USER_NAME")
	private String name;
	@Column(name = "USER_EMAIL")
	private String email;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private Address address;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private Room room;
	
	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String toString() {
		return "User[" + name + "]";
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
}
