package com.tca.entites;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ENGINE")
public class Engine {

	@Id
	@Column(name="EID")
	private Integer eid;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="SIZE")
	private String size;
	
	@OneToOne(mappedBy="engine",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	Car car;

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	} 
	
	
}
