/**
 * 
 */
package hibrenate;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rajni.hibernate.mapping.om_mo.Bid;
import com.rajni.hibernate.mapping.om_mo.Buyer;
import com.rajni.hibernate.mapping.om_mo.Product;
import com.rajni.hibernate.util.HibernateUtil;

/**
 * @author rajni.ubhi
 *
 */
public class OneToManyTest {
	public static void main(String[] args) {
		//saveProduct();
		saveBuyer();
	}
	static void saveProduct() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Product product = new Product();
		product.setInitialPrice(new BigDecimal(123.52));
		product.setProductName("ProductA");
		Bid bid = new Bid();
		bid.setBidAmount(new BigDecimal(123.52));
		product.addBid(bid);
		session.save(product);
		tx.commit();
		HibernateUtil.closeResources();
	}
	
	static void saveBuyer() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Product product = new Product();
		product.setInitialPrice(new BigDecimal(123.566));
		product.setProductName("ProductB");
		Bid bid = new Bid();
		bid.setBidAmount(new BigDecimal(3255.52));
		Buyer buyer = new Buyer();
		buyer.setBuyerName("Rajni");
		buyer.addBoughtItem(product);
		product.addBid(bid);
		session.save(buyer);
		tx.commit();
		HibernateUtil.closeResources();
	}
}
