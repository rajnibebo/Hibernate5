/**
 * 
 */
package com.rajni.hibernate.collection.test;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rajni.hibernate.collection.Bid;
import com.rajni.hibernate.collection.CartItem;
import com.rajni.hibernate.util.HibernateUtil;

/**
 * @author rajni.ubhi
 *
 */
public class CartItemTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addBids();
	}
	static void addBids() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		CartItem item = new CartItem();
		item.setName("ItemA");
		item.setPrice(new BigDecimal(12.36));
		Bid bid1 = new Bid();
		bid1.setBidAmount(new BigDecimal(10.36));
		Bid bid2 = new Bid();
		bid2.setBidAmount(new BigDecimal(9.36));
		Bid bid3 = new Bid();
		bid3.setBidAmount(new BigDecimal(8.36));
		Bid bid4 = new Bid();
		bid4.setBidAmount(new BigDecimal(11.36));
		
		item.addBid(bid1);
		item.addBid(bid2);
		item.addBid(bid3);
		item.addBid(bid4);
		session.save(item);
		tx.commit();
		HibernateUtil.closeResources();
	}

}
