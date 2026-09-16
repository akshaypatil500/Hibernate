package com.tca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")     //it is optional to write
public class Student {
	
	@Id
	@Column(name="RNO" )    //it is optional to write
	private Integer rno;
	
	@Column(name="NAME", nullable=false , length=50) // nullable->null , varchar-length
	private String name;
	
	@Column(name="PER", columnDefinition=" Double check(per>=0 and per<=100")
	private Double per;
	
	@Column(name="email" ,unique=true) //unique
	private String email;
	
	public Student() {} 

	public Integer getRno() {
		return rno;
	}

	public void setRno(Integer rno) {
		this.rno = rno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPer() {
		return per;
	}

	public void setPer(Double per) {
		this.per = per;
	}
	
	
	

	
}
