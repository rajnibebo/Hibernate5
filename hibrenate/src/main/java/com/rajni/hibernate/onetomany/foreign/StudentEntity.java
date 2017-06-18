/**
 * 
 */
package com.rajni.hibernate.onetomany.foreign;

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
@Table(name = "TBL_STUDENT")
public class StudentEntity {
	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID")
	private Long studentID;
	@Column(name = "NAME")
	private String name;
	@Column(name = "EMAIL")
	private String email;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private Set<AddressEntity> addressList = new HashSet<AddressEntity>();
	
	public Long getStudentID() {
		return studentID;
	}
	public void setStudentID(Long studentID) {
		this.studentID = studentID;
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
	public Set<AddressEntity> getAddressList() {
		return addressList;
	}
	public void setAddressList(Set<AddressEntity> addressList) {
		this.addressList = addressList;
	}
	public void addAddress(AddressEntity addressEntity) {
		this.addressList.add(addressEntity);
		addressEntity.setStudent(this);
	}
}
