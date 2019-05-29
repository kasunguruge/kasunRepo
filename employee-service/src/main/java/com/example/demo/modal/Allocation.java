package com.example.demo.modal;

import javax.persistence.*;
import java.util.Date;


public class Allocation {

	Integer id;
	Integer empId;

	Date from;

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
