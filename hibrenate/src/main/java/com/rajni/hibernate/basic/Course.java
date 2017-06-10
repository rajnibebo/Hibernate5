/**
 * 
 */
package com.rajni.hibernate.basic;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rajni.ubhi
 *
 */
@Entity
@Table(name = "TBL_COURSE")
public class Course {
	@EmbeddedId
	private CourseId courseId;
	@Column(name = "COURSE_NAME")
	private String name;
	@Column(name = "COURSE_DURATION")
	private int duration;
	public CourseId getCourseId() {
		return courseId;
	}
	public void setCourseId(CourseId courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
