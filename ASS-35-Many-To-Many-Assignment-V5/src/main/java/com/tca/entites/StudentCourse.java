package com.tca.entites;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="STUDENTCOURSE")
public class StudentCourse {

	@Id
	@Column(name="ID")
	private Integer id;
	
	@ManyToOne( cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="FK_RNO")
	Student student;
	
	@ManyToOne( cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="FK_CID")
	Course course;
	
	@JoinColumn(name="REG_DATE")
	LocalDate reg_date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDate getReg_date() {
		return reg_date;
	}

	public void setReg_date(LocalDate reg_date) {
		this.reg_date = reg_date;
	}
	
	
}
