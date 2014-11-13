package com.nepse.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Company")
public class Company {

	public Company(){
		
	}
	
	public Company(String name, String symbol) {
		super();
		this.name = name;
		this.symbol = symbol;
	}
	@Column(nullable=false)
	private String name;
	
	@Id
	private String symbol;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
}