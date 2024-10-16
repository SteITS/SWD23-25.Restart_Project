package com.restart.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "subtypes")
public class Subtype {

	//Id dell'oggetto
	@Id
	@Column(name = "id",nullable = false, length = 50)
	private int id;
	
	//Nome del sottotipo
	@Column(name = "name", length = 50)
	private String name;

	//Set di carte associate allo stesso sottotipo
	@ManyToMany(mappedBy="subtypes",fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<Card> cards;
	
	//Metodi getter e setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	
}
