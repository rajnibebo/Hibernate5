/**
 * 
 */
package hibrenate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rajni.hibernate.onetomany.foreign.AddressEntity;
import com.rajni.hibernate.onetomany.foreign.StudentEntity;
import com.rajni.hibernate.onetomany.jointable.AddressJoinEntity;
import com.rajni.hibernate.onetomany.jointable.StudentJoinEntity;
import com.rajni.hibernate.util.HibernateUtil;

/**
 * @author rajni.ubhi
 *
 */
public class OneToManyTest {
	public static void main(String[] args) {
		//testForeignKeyAssociation();
		//getAddress();
		testJoinTableAssociation();
	}
	static void testForeignKeyAssociation() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setEmail("Rajni@gmail.com");
		studentEntity.setName("Rajni");
		studentEntity.addAddress(new AddressEntity("Ldh", "Punjab", "India"));
		studentEntity.addAddress(new AddressEntity("Chandigarh", "Punjab", "India"));
		session.save(studentEntity);
		tx.commit();
		HibernateUtil.closeResources();
	}
	
	static void getAddress() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		StudentEntity studentEntity = session.get(StudentEntity.class, 73l);
		System.out.println(studentEntity.getAddressList());
		tx.commit();
		HibernateUtil.closeResources();
	}
	
	static void testJoinTableAssociation() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		StudentJoinEntity student = new StudentJoinEntity();
		student.setEmail("Rajni@gmail.com");
		student.setFirstName("Rajni");
		student.setLastName("Ubhi");
		student.addAddress(new AddressJoinEntity("Ludhiana", "Punjab", "India"));
		student.addAddress(new AddressJoinEntity("Chandigarh", "Punjab", "India"));
		session.save(student);
		tx.commit();
		HibernateUtil.closeResources();
	}
}
