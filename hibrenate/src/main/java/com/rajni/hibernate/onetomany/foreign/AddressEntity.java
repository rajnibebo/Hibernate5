/**
 * 
 */
package com.rajni.hibernate.onetomany.foreign;

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
@Table(name = "TBL_ADDRESS")
public class AddressEntity {
	@Id
	@GeneratedValue
	@Column(name = "ADDRESS_ID")
	private Long addressID;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "COUNTRY")
	private String country;
	@ManyToOne
	@JoinColumn(name = "STUDENT_ID")
	private StudentEntity student;
	
	public AddressEntity() {
		// TODO Auto-generated constructor stub
		System.out.println("Default constructor");
	}
	
	public AddressEntity(String city, String state, String country) {
		// TODO Auto-generated constructor stub
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public Long getAddressID() {
		return addressID;
	}

	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}
	
}
