package com.restart.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "supertypes")
public class Supertype {

	//Id dell'oggetto
	@Id
    private int id;

	//Nome del supertipo 
    private String name;

    //Lista di carte associate allo stesso supertipo
    @OneToMany(mappedBy = "supertype")
    @JsonBackReference
    private List<Card> cards;

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
