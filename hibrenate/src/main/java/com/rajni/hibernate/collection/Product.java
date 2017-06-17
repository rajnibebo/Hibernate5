/**
 * 
 */
package com.rajni.hibernate.collection;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.ListIndexBase;
import org.hibernate.annotations.SortNatural;
import org.hibernate.annotations.Type;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name = "TBL_PRODUCT")
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID")
	private Long productID;
	@Column(name = "PRODUCT_NAME")
	private String name;
	@Column(name = "PRODUCT_PRICE")
	private BigDecimal price;

	@ElementCollection
	@CollectionTable(name = "TBL_PRODUCT_IMAGES", joinColumns = @JoinColumn(name = "PROD_ID"))
	@Column(name = "IMAGE_NAME")
	private Set<String> images = new HashSet<String>();

	@ElementCollection
	@CollectionTable(name = "TBL_USER_UPLOAD_IMAGES", joinColumns = @JoinColumn(name = "PROD_ID"))
	@CollectionId(type = @Type(type = "java.lang.Long"), columns = @Column(name = "IMAGE_ID"), generator = "sequence")
	@Column(name = "IMAGE_NAME")
	private Collection<String> userUploadedImages = new ArrayList<String>();

	@ElementCollection
	@CollectionTable(name = "TBL_PROD_ALT_IMAGES", joinColumns = @JoinColumn(name = "PROD_ID"))
	@OrderColumn(name = "IMG_IDX")
	@ListIndexBase(value = 1)
	@Column(name = "PROD_IMAGE")
	//@OrderBy("PROD_IMAGE DESC") //-- it will not work with @OrderColumn annotation, better not to use here
	private List<String> alternativeImages = new ArrayList<String>();
	
	@ElementCollection
	@CollectionTable(name = "TBL_PROD_SPEC", joinColumns = @JoinColumn(name = "PROD_ID"))
	@MapKeyColumn(name = "SPEC_KEY_ID")
	@Column(name = "SPEC_VALUE")
	private Map<String, String> productSpecifications = new HashMap<String, String>();
	
	@ElementCollection
	@CollectionTable(name = "TBL_PROD_THUMBNAIL", joinColumns = @JoinColumn(name = "ROD_ID"))
	@MapKeyColumn(name = "THUM_ID")
	@Column(name = "THUMB_VALUE")
	@SortNatural
	private SortedMap<Integer, String> thumbnails = new TreeMap<Integer, String>();
	
	@ElementCollection
	@CollectionTable(name = "TBL_RANKED_LOCATION", joinColumns = @JoinColumn(name = "PROD_ID"))
	@MapKeyColumn(name = "LOC_ID")
	@Column(name = "LOC_NAME")
	@OrderBy("LOC_NAME DESC")
	private Map<Integer, String> rankedLocations = new HashMap<Integer, String>();

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Set<String> getImages() {
		return images;
	}

	public void setImages(Set<String> images) {
		this.images = images;
	}

	public void addImage(String image) {
		this.images.add(image);
	}

	public void addUserUploadedImage(String image) {
		this.userUploadedImages.add(image);
	}

	public void addAltImage(String image) {
		this.alternativeImages.add(image);
	}

	public Collection<String> getUserUploadedImages() {
		return userUploadedImages;
	}

	public void setUserUploadedImages(Collection<String> userUploadedImages) {
		this.userUploadedImages = userUploadedImages;
	}

	public List<String> getAlternativeImages() {
		return alternativeImages;
	}

	public void setAlternativeImages(List<String> alternativeImages) {
		this.alternativeImages = alternativeImages;
	}

	public Map<String, String> getProductSpecifications() {
		return productSpecifications;
	}

	public void setProductSpecifications(Map<String, String> productSpecifications) {
		this.productSpecifications = productSpecifications;
	}

	public SortedMap<Integer, String> getThumbnails() {
		return thumbnails;
	}

	public void setThumbnails(SortedMap<Integer, String> thumbnails) {
		this.thumbnails = thumbnails;
	}

	public Map<Integer, String> getRankedLocations() {
		return rankedLocations;
	}

	public void setRankedLocations(Map<Integer, String> rankedLocations) {
		this.rankedLocations = rankedLocations;
	}

	public String toString() {
		return "Product[ ID : "+productID+", name : "+name+"]\n";
	}
}
