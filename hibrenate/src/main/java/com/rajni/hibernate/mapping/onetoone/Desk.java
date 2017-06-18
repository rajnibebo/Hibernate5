/**
 * 
 */
package com.rajni.hibernate.mapping.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name = "DESK")
@SecondaryTable(name = "DESK_ASSIGNMENT")
public class Desk {
	@Id
	@GeneratedValue
	@Column(name = "DESK_ID")
	private Long deskId;
	@Column(name = "DESK_NAME")
	private String deskName;
	@OneToOne
	@JoinColumn(table = "DESK_ASSIGNMENT", name = "USER_ID")
	private User user;

	public Long getDeskId() {
		return deskId;
	}

	public void setDeskId(Long deskId) {
		this.deskId = deskId;
	}

	public String getDeskName() {
		return deskName;
	}

	public void setDeskName(String deskName) {
		this.deskName = deskName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
