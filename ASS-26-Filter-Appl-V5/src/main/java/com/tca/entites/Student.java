package com.tca.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name="student")

@FilterDefs(
		{
			@FilterDef(name="cityfilter",parameters=@ParamDef(name="tca",type="string")),
			@FilterDef(name="perfilter",parameters=@ParamDef(name="pqr",type="double")),
			@FilterDef(name="percityfilter",parameters= {@ParamDef(name="lmn",type="string"),
                    @ParamDef(name="xyz",type="double")})


		})

@Filters(
		{
			@Filter(name="cityfilter",condition="scity=:tca"),
			@Filter(name="perfilter",condition="sper>=:pqr"),
			@Filter(name="percityfilter",condition="scity=:lmn and sper>=:xyz")
				
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
