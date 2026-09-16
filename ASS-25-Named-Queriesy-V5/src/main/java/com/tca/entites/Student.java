package com.tca.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="student")
@NamedQueries(
		
      value= {
    		  @NamedQuery(name="GET_ALL_INFO",query="from Student"),
    		  @NamedQuery(name="get_city_stud",query="from Student where scity=:abc"),
    		  @NamedQuery(name="update_city",query="update Student set city=:abc where city=:pqr"),
              @NamedQuery(name="remove_student",query="delete from Student where rno=:rollnumber")
    		    	  
      })


public class Student {
	
	@Id
	@Column(name="srno")
	private Integer rno;
	
	@Column(name="sname")
	private String name;
	
	@Column(name="sper")
	private Double per;
	
	@Column(name="scity")
	private String city;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	
	
	

	
}
