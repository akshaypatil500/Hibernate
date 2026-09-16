package com.tca.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COURSE")
public class Course {

	@Id
	@Column(name="CID")
	private Integer cid;
	
	@Column(name="CNAME")
	private String cname;
	
	@OneToMany(mappedBy="course")
	List<StudentCourse> regs;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<StudentCourse> getRegs() {
		return regs;
	}

	public void setRegs(List<StudentCourse> regs) {
		this.regs = regs;
	}
	
	

}
