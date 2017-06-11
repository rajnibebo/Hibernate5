/**
 * 
 */
package com.rajni.hibernate.component.collection;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Parent;

/**
 * @author rajni.ubhi
 *
 */
@Embeddable
public class Image {
	@Parent
	private Item item;
	@Column(name = "IMG_NAME", nullable = false)
	private String imageName;
	@Column(name = "IMG_SIZE", nullable = false)
	private int size;

	public Image() {
		// TODO Auto-generated constructor stub
	}

	public Image(String imageName, int size) {
		this.imageName = imageName;
		this.size = size;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int hashCode() {
		return imageName.hashCode() + size;
	}

	public boolean equals(Object object) {
		if (object == this) {
			return true;
		}
		if (object instanceof Image) {
			Image image = (Image) object;
			return image.getImageName().equals(imageName)
					&& image.getSize() == size;
		}
		return false;
	}
	
	public String toString() {
		return "["+imageName+"]";
	}
}
