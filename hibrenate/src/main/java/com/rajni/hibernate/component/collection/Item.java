/**
 * 
 */
package com.rajni.hibernate.component.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name = "TBL_ITEM")
public class Item {
	@Id
	@GeneratedValue
	@Column(name = "ITEM_ID")
	private Long itemId;

	@Column(name = "ITEM_NAME")
	private String itemName;

	@ElementCollection
	@CollectionTable(name = "TBL_ITEM_LOGO_IMG", joinColumns = @JoinColumn(name = "ITEM_ID"))
	@Embedded
	@OrderBy("IMG_NAME ASC")
	private Set<Image> logoImages = new HashSet<Image>();

	@ElementCollection
	@CollectionTable(name = "TBL_ITEM_IMG", joinColumns = @JoinColumn(name = "ITEM_ID"))
	@CollectionId(columns = @Column(name = "ITEM_IMG_ID"), generator = "sequence", type = @Type(type = "java.lang.Long"))
	@Embedded
	private Collection<Image> itemImages = new ArrayList<Image>();
	
	@ElementCollection
	@CollectionTable(name = "TBL_ITEM_BLOG_IMG", joinColumns = @JoinColumn(name = "ITEM_ID"))
	@MapKeyColumn(name = "IMG_NAME")
	@Embedded
	@OrderBy("IMG_NAME ASC")
	private Map<String, Image> itemBlogImages = new HashMap<String, Image>();
	
	@ElementCollection
	@JoinTable(name = "TBL_ITEM_PRICES")
	@Column(name = "ITEM_PRICE")
	private List<Double> itemPrices = new ArrayList<Double>();

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Set<Image> getLogoImages() {
		return logoImages;
	}

	public void setLogoImages(Set<Image> logoImages) {
		this.logoImages = logoImages;
	}

	public void addLogoImage(Image image) {
		this.logoImages.add(image);
		image.setItem(this);
	}

	public Collection<Image> getItemImages() {
		return itemImages;
	}

	public void setItemImages(Collection<Image> itemImages) {
		this.itemImages = itemImages;
	}

	public void addItemImage(Image image) {
		this.itemImages.add(image);
		image.setItem(this);
	}

	public Map<String, Image> getItemBlogImages() {
		return itemBlogImages;
	}

	public void setItemBlogImages(Map<String, Image> itemBlogImages) {
		this.itemBlogImages = itemBlogImages;
	}
	
	public void addBlogImage(String key, Image image) {
		this.itemBlogImages.put(key, image);
	}

	public List<Double> getItemPrices() {
		return itemPrices;
	}

	public void setItemPrices(List<Double> itemPrices) {
		this.itemPrices = itemPrices;
	}
	
}
