/**
 * 
 */
package com.rajni.hibernate.basic;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name = "TBL_EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "EMPLOYEE_ID")
	private Long employeeID;
	@Column(name = "EMP_NAME")
	private String name;

	@Column(name = "EMP_CREATE_DATE", updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Column(name = "EMP_LAST_MODIFIED")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUR_ADDRESS_ID")
	@AttributeOverrides({
		@AttributeOverride(column = @Column(name = "CUR_STATE"), name = "state"),
		@AttributeOverride(column = @Column(name = "CUR_CITY"), name = "city"),
		@AttributeOverride(column = @Column(name = "CUR_COUNTRY"), name = "country"),
		@AttributeOverride(column = @Column(name = "CUR_AREA_CODE"), name = "phoneNUmber.areaCode"),
		@AttributeOverride(column = @Column(name = "CUR_PHONE_NUMBER"), name = "phoneNUmber.phoneNumber")
	})
	private Address currentAddress;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address permanentAddress;

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public Address getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	@Override
	public String toString() {
		return "Employee [Id :: " + employeeID + ", name :: " + name + "]";
	}

}
