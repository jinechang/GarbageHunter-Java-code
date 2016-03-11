/*
 * @OneToMany
 
@ManyToOne(targetEntity=Teacher.class, cascade=CascadeType.ALL,fetch=FetchType.LAZY,optional=false)


place annotations either on the field or on the getter. 

*/

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Teacher")
public class Teacher extends P implements Serializable
{	
	private int Salary;
	private String degree;
	private University univ;
	
	public int getSalary() {
		return Salary;
	}
	
	public void setSalary(int salary) {
		Salary = salary;
	}
	
	public String getDegree() {
		return degree;
	}
	
	public void setDegree(String degree) {
		this.degree = degree;
	}

	@ManyToOne(targetEntity=University.class, cascade=CascadeType.ALL,fetch=FetchType.LAZY,optional=false)
	public University getUniv() {
		return univ;
	}

	public void setUniv(University univ) {
		this.univ = univ;
	}
}
