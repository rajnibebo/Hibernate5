/**
 * 
 */
package com.rajni.hibernate.util;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author rajni.ubhi
 *
 *         New Hibernate Utility using Java 8 Optional Class
 */
public class HibernateUtil {

	private static Optional<SessionFactory> sessionFactory = getSessionFactory();

	private static Session session = null;

	private static Optional<SessionFactory> getSessionFactory() {
		
		return Optional.of(new Configuration().configure().buildSessionFactory());
	}

	public static Session getSession() {
		if (session == null) {
			if (sessionFactory.isPresent()) {
				session = sessionFactory.get().openSession();
			} else {
				sessionFactory = getSessionFactory();
				if(sessionFactory.isPresent()) {
					session = sessionFactory.get().openSession();
				}
				
			}
		}
		return session;
	}

	public static void closeResources() {
		if (sessionFactory.isPresent()) {
			session.close();
			sessionFactory.get().close();
		}
	}

	public static void main(String[] args) {
		System.out.println(getSession());
		closeResources();
	}
}
