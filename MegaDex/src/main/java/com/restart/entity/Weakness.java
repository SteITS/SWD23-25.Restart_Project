package com.restart.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "weaknesses")
public class Weakness {
	
	//Id dell'oggetto
	@Id
	@Column(name = "id")
	private int id;
	
	//Stringa del tipo a cui è debole
	private String type;
	
	//Valore della debolezza
	private String value;

	//Set di carte legate alla stessa debolezza
	@ManyToMany(mappedBy="weaknesses")
	@JsonBackReference
	private Set<Card> cards;
	
	
	//Metodi getter e setter
	public String getText() {
		return type;
	}

	public void setText(String text) {
		this.type = text;
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
