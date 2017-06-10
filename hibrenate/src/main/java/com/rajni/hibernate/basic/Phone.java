/**
 * 
 */
package com.rajni.hibernate.basic;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author rajni.ubhi
 *
 */
@Embeddable
public class Phone {
	@Column(name = "AREA_CODE")
	private int areaCode;
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	public int getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
