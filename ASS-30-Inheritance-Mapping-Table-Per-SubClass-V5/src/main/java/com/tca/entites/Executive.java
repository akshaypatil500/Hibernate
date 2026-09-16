package com.tca.entites;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="EXE2")
@PrimaryKeyJoinColumn(name="eid")
public class Executive extends Employee {
	
	@Column(name="erole")
	private String erole;

	public String getErole() {
		return erole;
	}

	public void setErole(String erole) {
		this.erole = erole;
	}
	
	

}
