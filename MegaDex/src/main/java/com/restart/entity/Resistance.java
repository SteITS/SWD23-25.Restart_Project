package com.restart.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "resistances")
public class Resistance {
	
	@Id
	@Column(name = "id")
	private int id;
	
	private String type;
	
	private String value;

	public String getType() {
		return type;
	}

	@ManyToMany(mappedBy="resistances")
	@JsonBackReference
	private Set<Card> cards;
	
	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}
	
	
	
}
