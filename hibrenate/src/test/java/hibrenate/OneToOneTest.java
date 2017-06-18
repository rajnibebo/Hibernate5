/**
 * 
 */
package hibrenate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rajni.hibernate.onetoone.foreign.AccountEntity;
import com.rajni.hibernate.onetoone.foreign.EmployeeEntity;
import com.rajni.hibernate.onetoone.jointable.AccountJoinEntity;
import com.rajni.hibernate.onetoone.jointable.EmployeeJoinEntity;
import com.rajni.hibernate.onetoone.sharedPK.AccountPK;
import com.rajni.hibernate.onetoone.sharedPK.EmployeePK;
import com.rajni.hibernate.util.HibernateUtil;

/**
 * @author rajni.ubhi
 *
 */
public class OneToOneTest {
	
	public static void main(String[] args) {
		testForeignKeyAssociation();
		testJoinTableAssociation();
		testSharedPrimaryKey();
		HibernateUtil.closeResources();
	}
	static void testForeignKeyAssociation() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		EmployeeEntity employee = new EmployeeEntity();
		employee.setEmail("Rajni@gmail.com");
		employee.setFirstName("Rajni");
		employee.setLastName("Ubhi");
		
		AccountEntity account = new AccountEntity();
		account.setAccountNumber("123456789");
		account.setEmployee(employee);
		employee.setAccount(account);
		
		session.save(account);
		tx.commit();
	}
	
	static void testJoinTableAssociation() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		EmployeeJoinEntity employee = new EmployeeJoinEntity();
		employee.setEmail("Rajni@gmail.com");
		employee.setFirstName("Rajni");
		employee.setLastName("Ubhi");
		
		AccountJoinEntity account = new AccountJoinEntity();
		account.setAccountNumber("123456789");
		account.setEmployee(employee);
		employee.setAccount(account);
		
		session.save(account);
		tx.commit();
	}
	
	static void testSharedPrimaryKey() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		AccountPK account = new AccountPK();
		account.setAccountNumber("abcdefghi");
		
		EmployeePK employee = new EmployeePK();
		employee.setEmail("Rajni@gmail.com");
		employee.setFirstName("Rajni");
		employee.setLastName("Ubhi");
		employee.setAccount(account);
		account.setEmployee(employee);
		
		session.save(account);
		tx.commit();
	}
}
