/**
 * 
 */
package com.rajni.hibernate.onetoone.sharedPK;

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
@Table(name = "TBL_ACCOUNT_PK")
public class AccountPK {
	@Id
	@GeneratedValue
	@Column(name = "ACCOUNT_ID")
	private Long accountID;
	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
	private EmployeePK employee;

	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public EmployeePK getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeePK employee) {
		this.employee = employee;
	}

}
