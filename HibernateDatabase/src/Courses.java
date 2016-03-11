/*
 * @OneToMany

@ManyToOne(targetEntity=Teacher.class, cascade=CascadeType.ALL,fetch=FetchType.LAZY,optional=false)
 */


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Courses implements Serializable {
	private int id;
	private String courseName;
	private int year;
	private Teacher T;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	@ManyToOne(targetEntity=Teacher.class, cascade=CascadeType.ALL,fetch=FetchType.LAZY,optional=false)
	public Teacher getT() {
		return T;
	}
	public void setT(Teacher t) {
		T = t;
	}
	
	
	
	
	
}
