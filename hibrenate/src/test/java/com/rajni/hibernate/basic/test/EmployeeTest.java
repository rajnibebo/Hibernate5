/**
 * 
 */
package com.rajni.hibernate.basic.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rajni.hibernate.basic.Address;
import com.rajni.hibernate.basic.Employee;
import com.rajni.hibernate.basic.Phone;
import com.rajni.hibernate.util.HibernateUtil;

/**
 * @author rajni.ubhi
 *
 */
public class EmployeeTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = session.get(Employee.class, 1l);
		employee.setName("Rajni");
		
		Address address = new Address();
		Address curAddress = new Address();
		Phone p1 = new Phone();
		p1.setAreaCode(91);
		p1.setPhoneNumber("123456789");
		
		Phone p2 = new Phone();
		p2.setAreaCode(91);
		p2.setPhoneNumber("987456123");
		
		address.setCity("Ludhiana");
		address.setCountry("India");
		address.setPhoneNUmber(p1);
		address.setState("Punjab");
		
		curAddress.setCity("Chandigarh");
		curAddress.setCountry("India");
		curAddress.setPhoneNUmber(p2);
		curAddress.setState("Punjab");
		employee.setCurrentAddress(curAddress);
		employee.setPermanentAddress(address);
		
		session.save(employee);
		transaction.commit();
		HibernateUtil.closeResources();
	}
}
