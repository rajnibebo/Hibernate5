/**
 * 
 */
package com.rajni.hibernate.basic.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rajni.hibernate.basic.Course;
import com.rajni.hibernate.basic.CourseId;
import com.rajni.hibernate.util.HibernateUtil;

/**
 * @author rajni.ubhi
 *
 */
public class CourseTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		CourseId courseId = new CourseId();
		courseId.setTitle("Hibernate");
		courseId.setTutor("Rajni");
		Course course = new Course();
		course.setName("Basics");
		course.setDuration(6);
		course.setCourseId(courseId);
		session.save(course);
		tx.commit();
		HibernateUtil.closeResources();
	}
}
