/**
 * 
 */
package com.rajni.hibernate.onetoone.sharedPK;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name = "TBL_EMPLOYEE_PK")
public class EmployeePK {
	@Id
	@GenericGenerator(name = "foreignKeyGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "account"))
	@GeneratedValue(generator = "foreignKeyGenerator")
	@Column(name = "EMPLOYEE_ID")
	private Long employeeID;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@OneToOne
	@PrimaryKeyJoinColumn
	private AccountPK account;

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

	public AccountPK getAccount() {
		return account;
	}

	public void setAccount(AccountPK account) {
		this.account = account;
	}

}
