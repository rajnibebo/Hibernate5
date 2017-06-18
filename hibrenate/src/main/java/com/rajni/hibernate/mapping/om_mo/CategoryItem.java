/**
 * 
 */
package com.rajni.hibernate.mapping.om_mo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name = "TBL_CAT_ITEM")
public class CategoryItem {
	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ITEM_ID")
	private Long categoryItemID;
	@Column(name = "ITEM_NAME")
	private String name;
	@ManyToMany
	private Set<Category> category;
	
	public Long getCategoryItemID() {
		return categoryItemID;
	}
	public void setCategoryItemID(Long categoryItemID) {
		this.categoryItemID = categoryItemID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Category> getCategory() {
		return category;
	}
	public void setCategory(Set<Category> category) {
		this.category = category;
	}
	
}
