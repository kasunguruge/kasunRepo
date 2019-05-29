package lk.kasun.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Allocation {

	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	Integer empId;
	@Column(name="from_date")
	Date from;
	@Column(name="to_date")
	Date to;
	String project;
	
	
	public String getProject() {
		return project;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Date getFrom() {
		return from;
	}
	public Date getTo() {
		return to;
	}
	public void setProject(String project) {
		this.project = project;
	}
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	
}
