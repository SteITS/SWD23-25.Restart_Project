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
	
	//Id dell'oggetto
	@Id
	@Column(name = "id")
	private int id;
	
	//Tipo elementale della resistenza al danno
	private String type;
	
	//Valore della resistenza
	private String value;

	//Set di carte associate alla stessa resistenza
	@ManyToMany(mappedBy="resistances")
	@JsonBackReference
	private Set<Card> cards;

	//Metodi getter e setter
	public String getType() {
		return type;
	}
	
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
