package com.restart.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="abilities")
public class Ability {
	
	//Id dell'oggetto
	@Id
	private int id;
	
	//Nome dell'abilità
	private String name;
	
	//Testo descrittivo dell'abilità
	private String text;
	
	//Tipo dell'abilità
	private String type;

	//Set di carte che possiedono la stessa abilità
	@ManyToMany(mappedBy="abilities")
	@JsonBackReference
	private Set<Card> cards;
	
	//Metodi getter e setter
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
