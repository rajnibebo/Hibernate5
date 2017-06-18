/**
 * 
 */
package com.rajni.hibernate.onetomany.jointable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name = "TBL_JOIN_STUDENT")
public class StudentJoinEntity {
	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID")
	private Long studentID;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private Set<AddressJoinEntity> addressList = new HashSet<AddressJoinEntity>();

	public Long getStudentID() {
		return studentID;
	}

	public void setStudentID(Long studentID) {
		this.studentID = studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<AddressJoinEntity> getAddressList() {
		return addressList;
	}

	public void setAddressList(Set<AddressJoinEntity> addressList) {
		this.addressList = addressList;
	}

	public void addAddress(AddressJoinEntity address) {
		this.addressList.add(address);
		address.setStudent(this);
	}
}
