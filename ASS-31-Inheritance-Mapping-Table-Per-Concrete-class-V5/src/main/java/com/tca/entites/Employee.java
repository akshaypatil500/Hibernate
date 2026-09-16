package com.tca.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name="EMP3")
public class Employee extends Person{
	
	
	@Column(name="esalary")
	private Double esalary;

	
	public Double getEsalary() {
		return esalary;
	}

	public void setEsalary(Double esalary) {
		this.esalary = esalary;
	}
	
	
	
	

}
