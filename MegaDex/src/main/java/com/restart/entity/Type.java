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

	@Id
	@Column(name = "id")
	private int id;
	
	private String name;

	@ManyToMany(mappedBy="types")
	@JsonBackReference
	private Set<Card> cards;
	
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
