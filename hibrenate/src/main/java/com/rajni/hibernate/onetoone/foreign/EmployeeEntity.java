/**
 * 
 */
package com.rajni.hibernate.onetoone.foreign;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name = "TBL_EMP")
public class EmployeeEntity {
	@Id
	@GeneratedValue
	@Column(name = "EMPLOYEE_ID")
	private Long employeeID;
	@Column(name = "EMP_FIRST_NAME")
	private String firstName;
	@Column(name = "EMP_LAST_NAME")
	private String lastName;
	@Column(name = "EMP_EMAIL")
	private String email;
	@OneToOne
	@JoinColumn(name = "ACCOUNT_ID")
	private AccountEntity account;

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

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

}
