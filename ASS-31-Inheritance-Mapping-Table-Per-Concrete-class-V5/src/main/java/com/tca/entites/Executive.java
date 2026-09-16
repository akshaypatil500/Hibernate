package com.tca.entites;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="EXE3")
public class Executive extends Person {

	@Column(name="bonus")
	private Double bonus;
	
	@Column(name="erole")
	private String erole;

	
	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	public String getErole() {
		return erole;
	}

	public void setErole(String erole) {
		this.erole = erole;
	}
	
	
}
