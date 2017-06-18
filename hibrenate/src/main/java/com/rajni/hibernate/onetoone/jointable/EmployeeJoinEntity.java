/**
 * 
 */
package com.rajni.hibernate.onetoone.jointable;

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
@Table(name = "TBL_JOIN_EMP")
public class EmployeeJoinEntity {
	@Id
	@GeneratedValue
	@Column(name = "EMPLOYEE_ID")
	private Long employeeID;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@OneToOne
	@JoinTable(name = "TBL_EMP_ACCT", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"), inverseJoinColumns = @JoinColumn(name = "ACCOUNT_ID"))
	private AccountJoinEntity account;

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
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

	public AccountJoinEntity getAccount() {
		return account;
	}

	public void setAccount(AccountJoinEntity account) {
		this.account = account;
		//this.account.setEmployee(this);
	}

}
