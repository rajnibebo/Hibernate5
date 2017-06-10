/**
 * 
 */
package com.rajni.hibernate.basic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author rajni.ubhi
 *
 */
@Embeddable
public class CourseId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "COURSE_TUTOR")
	private String tutor;
	@Column(name = "COURSE_TITLE")
	private String title;
	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return tutor.hashCode() + title.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this == obj) {
			return true;
		}
		if(obj instanceof CourseId) {
			CourseId courseId = (CourseId) obj;
			return courseId.title.equals(title) && courseId.tutor.equals(tutor);
		}
		return false;
	}
	public String toString() {
		return "Course [ Tutor : "+tutor+", title : "+title+"]";
	}
}
