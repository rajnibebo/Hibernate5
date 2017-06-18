/**
 * 
 */
package hibrenate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rajni.hibernate.mapping.om_mo.Category;
import com.rajni.hibernate.mapping.om_mo.CategoryItem;
import com.rajni.hibernate.util.HibernateUtil;

/**
 * @author rajni.ubhi
 *
 */
public class ManyToManyTest {
	
	public static void main(String[] args) {
		
	}
	
	static void saveCategory() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Category category = new Category();
		category.setCategoryName("Category1");
		CategoryItem item  = new CategoryItem();
		tx.commit();
		HibernateUtil.closeResources();
	}
}
