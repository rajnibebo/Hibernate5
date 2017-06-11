/**
 * 
 */
package com.rajni.hibernate.component.collection.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rajni.hibernate.component.collection.Image;
import com.rajni.hibernate.component.collection.Item;
import com.rajni.hibernate.util.HibernateUtil;

/**
 * @author rajni.ubhi
 *
 */
public class ItemTest {

	static int count = 1;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//saveItem();
		//saveLogoImages();
		//saveItemImages();
		//saveItemBlogImages();
		//getItemBlogImages();
		saveItemPrice();
	}

	static void saveItem() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Item item = new Item();
		item.setItemName("ItemB");
		session.save(item);
		System.out.println("Item saved :: "+item.getItemId());
		tx.commit();
		HibernateUtil.closeResources();
	}
	static void saveLogoImages() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Image image1 = new Image();
		image1.setImageName("I_1.jpg");
		image1.setSize(123);
		Item item = session.get(Item.class, 10l);
		item.addLogoImage(image1);
		item.addLogoImage(new Image("I_2.jpg", 258));
		item.addLogoImage(new Image("A_1.png",1236));
		session.save(item);
		tx.commit();
		HibernateUtil.closeResources();
	}
	static void saveItemImages() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Image image1 = new Image();
		image1.setImageName("I_1.jpg");
		image1.setSize(123);
		Item item = session.get(Item.class, 10l);
		item.addItemImage(image1);
		item.addItemImage(new Image("I_2.jpg", 258));
		item.addItemImage(new Image("A_1.png",1236));
		session.save(item);
		tx.commit();
		HibernateUtil.closeResources();
	}
	
	static void saveItemBlogImages() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Image image1 = new Image();
		image1.setImageName("I_1.jpg");
		image1.setSize(123);
		Item item = session.get(Item.class, 10l);
		item.addBlogImage(image1.getImageName(), image1);
		item.addBlogImage("I_2.jpg",new Image("I_2.jpg", 258));
		item.addBlogImage("A_1.png",new Image("A_1.png",1236));
		session.save(item);
		tx.commit();
		HibernateUtil.closeResources();
	}
	static void getItemBlogImages() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Item item = session.get(Item.class, 10l);
		System.out.println(item.getItemBlogImages());
		tx.commit();
		HibernateUtil.closeResources();
	}
	
	static void saveItemPrice() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Item item = session.get(Item.class, 10l);
		List<Double> doubles = new ArrayList<Double>();
		doubles.add(2.58);
		doubles.add(25.36);
		item.setItemPrices(doubles);
		session.save(item);
		tx.commit();
		HibernateUtil.closeResources();
	}
}
