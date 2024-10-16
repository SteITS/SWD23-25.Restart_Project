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
@Table(name="attacks")
public class Attack {
	
	//Id dell'oggetto
	@Id
	@Column(name = "id", nullable = false, length = 50)
	private int id;
	
	//Nome dell'attacco
	@Column(name="attack_name", length = 50)
	private String attack_name;
	
	//Costo in energie dell'attacco
	@Column(name="cost", length = 100)
	private String cost;
	
	//Danno dell'attacco
	@Column(name="damage", length = 150)
	private String damage;
	
	//Costo in energie dell'attacco convertito in simboli
	private int converted_energy_cost;
	
	//Testo descrittivo dell'attacco
	private String text;
	
	//Carte che hanno lo stesso attacco
	@ManyToMany(mappedBy="attacks", fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<Card> cards;

	//Metodi getter e setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAttack_name() {
		return attack_name;
	}

	public void setAttack_name(String attack_name) {
		this.attack_name = attack_name;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getDamage() {
		return damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	public int getConvertedEnergyCost() {
		return converted_energy_cost;
	}

	public void setConvertedEnergyCost(int convertedEnergyCost) {
		this.converted_energy_cost = convertedEnergyCost;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
}
