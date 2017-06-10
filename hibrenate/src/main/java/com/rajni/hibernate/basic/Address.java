/**
 * 
 */
package com.rajni.hibernate.basic;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name="ADDRESS")
public class Address {
	@Id
	@GeneratedValue
	@Column(name = "ADDRESS_ID")
	private Long addressID;
	@Column(name = "STATE")
	private String state;
	@Column(name = "CITY")
	private String city;
	@Column(name = "COUNTRY")
	private String country;
	@Embedded
	private Phone phoneNUmber;
	
	public Long getAddressID() {
		return addressID;
	}
	public void setAddressID(Long addressId) {
		this.addressID = addressId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Phone getPhoneNUmber() {
		return phoneNUmber;
	}
	public void setPhoneNUmber(Phone phoneNUmber) {
		this.phoneNUmber = phoneNUmber;
	}
	
}
