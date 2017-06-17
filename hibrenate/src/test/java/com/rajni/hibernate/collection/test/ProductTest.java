/**
 * 
 */
package com.rajni.hibernate.collection.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rajni.hibernate.collection.Product;
import com.rajni.hibernate.util.HibernateUtil;

/**
 * @author rajni.ubhi
 *
 */
public class ProductTest {
	public static void main(String[] args) {
		//saveAlternateImages();
		//saveSpecifications();
		//saveThumbnails();
		//saveRankedLocations();
		//getRankedLocations();
		getAlternateImages();
	}
	
	static void saveUserUploadedImage() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Product product = session.get(Product.class, 4l);
		product.addUserUploadedImage("U1.jpg");
		product.addUserUploadedImage("U3.png");
		product.addUserUploadedImage("U2.jpg");
		session.saveOrUpdate(product);
		tx.commit();
		HibernateUtil.closeResources();
	}
	
	static void saveAlternateImages() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Product product = new Product();
		product.setName("ProductCommon");
		product.setPrice(new BigDecimal(125));
		product.addAltImage("Img1.jpg");
		product.addAltImage("Img2.jpg");
		product.addAltImage("Img3.jpg");
		session.save(product);
		tx.commit();
		HibernateUtil.closeResources();
	}
	
	static void getAlternateImages() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Product product = session.get(Product.class, 4l);
		System.out.println(product.getAlternativeImages());
		tx.commit();
		HibernateUtil.closeResources();
	}
	
	static void saveSpecifications() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Product product = session.get(Product.class, 4l);
		Map<String, String> specs = new HashMap<String, String>();
		specs.put("Ram", "4GB");
		specs.put("weight", "15 lbs");
		specs.put("height", "12");
		specs.put("length", "30");
		product.setProductSpecifications(specs);
		session.save(product);
		tx.commit();
		HibernateUtil.closeResources();
	}
	
	static void saveThumbnails() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Product product = session.get(Product.class, 8l);
		SortedMap<Integer, String> thumbnails = new TreeMap<Integer, String>();
		thumbnails.put(3, "3X3");
		thumbnails.put(4, "4X4");
		thumbnails.put(1, "1X1");
		thumbnails.put(2, "2X2");
		product.setThumbnails(thumbnails);
		session.save(product);
		tx.commit();
		HibernateUtil.closeResources();
	}
	
	static void saveRankedLocations() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Product product = session.get(Product.class, 8l);
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "LOC1");
		map.put(4, "LOC4");
		map.put(3, "LOC3");
		map.put(2, "LOC2");
		product.setRankedLocations(map);
		session.save(product);
		tx.commit();
		HibernateUtil.closeResources();
	}
	
	static void getRankedLocations() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Product product = session.get(Product.class, 8l);
		System.out.println(product.getRankedLocations());
		tx.commit();
		HibernateUtil.closeResources();
	}
}
