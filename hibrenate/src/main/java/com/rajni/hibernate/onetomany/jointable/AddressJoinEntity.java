/**
 * 
 */
package com.rajni.hibernate.onetomany.jointable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name = "TBL_JOIN_ADDRESS")
public class AddressJoinEntity {
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
	@JoinTable(name = "TBL_STUDENT_ADDRESS", joinColumns = @JoinColumn(name = "ADDRESS_ID"), inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
	private StudentJoinEntity student;

	public AddressJoinEntity() {
		// TODO Auto-generated constructor stub
	}

	public AddressJoinEntity(String city, String state, String country) {
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

	public StudentJoinEntity getStudent() {
		return student;
	}

	public void setStudent(StudentJoinEntity student) {
		this.student = student;
	}

}
