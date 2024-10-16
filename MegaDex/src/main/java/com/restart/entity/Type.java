package com.restart.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "types")
public class Type {

	//Id della classe
	@Id
	@Column(name = "id")
	private int id;
	
	//Nome del tipo elementale
	private String name;

	//Set di carte legate al singolo record elemento
	@ManyToMany(mappedBy="types")
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
