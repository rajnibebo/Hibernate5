/**
 * 
 */
package com.rajni.hibernate.mapping.om_mo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name = "TBL_CATEGORY")
public class Category {
	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private Long categoryID;
	@Column(name = "CATEGORY_NAME")
	private String categoryName;
	@ManyToMany
	@JoinTable(name = "TBL_LIST_CAT_ITEM", joinColumns = @JoinColumn(name = "CAT_ID"), 
		inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
	@ListIndexBase(value = 1)
	@OrderColumn(name = "POSITION")
	private Set<CategoryItem> categoryItems = new HashSet<CategoryItem>();

	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<CategoryItem> getCategoryItems() {
		return categoryItems;
	}

	public void setCategoryItems(Set<CategoryItem> categoryItems) {
		this.categoryItems = categoryItems;
	}
	
	public void addCategoryItem(CategoryItem item) {
		this.categoryItems.add(item);
		//item.se
	}

}
