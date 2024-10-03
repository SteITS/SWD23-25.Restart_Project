package com.restart.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "cards")
public class Card {
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "expansion")
	private String set;
	
	private String series;
	
	private String publisher;
	
	private String generation;
	
	private String release_date;
	
	private String artist;
	
	private String name;
	
	private String set_num;
	
	private String supertype;
	
	private String levell;
	
	private String hp;
	
	private String evolves_from;
	
	private String evolves_to;
	
	private String retreat_cost;
	
	private String converted_retreat_cost;
	
	private String rarity;
	
	private String flavor_text;
	
	private String national_pokedex_numbers;
	
	private String legalities;
	
	private String rules;
	
	private String regulation_mark;
	
	private String ancient_trait;
	
	private String img;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSet() {
		return set;
	}

	public void setSet(String set) {
		this.set = set;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSet_num() {
		return set_num;
	}

	public void setSet_num(String set_num) {
		this.set_num = set_num;
	}

	public String getSupertype() {
		return supertype;
	}

	public void setSupertype(String supertype) {
		this.supertype = supertype;
	}

	public String getLevel() {
		return levell;
	}

	public void setLevel(String level) {
		this.levell = level;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getEvolvesFrom() {
		return evolves_from;
	}

	public void setEvolvesFrom(String evolvesFrom) {
		this.evolves_from = evolvesFrom;
	}

	public String getEvolvesTo() {
		return evolves_to;
	}

	public void setEvolvesTo(String evolvesTo) {
		this.evolves_to = evolvesTo;
	}

	public String getRetreatCost() {
		return retreat_cost;
	}

	public void setRetreatCost(String retreatCost) {
		this.retreat_cost = retreatCost;
	}

	public String getConvertedRetreatCost() {
		return converted_retreat_cost;
	}

	public void setConvertedRetreatCost(String convertedRetreatCost) {
		this.converted_retreat_cost = convertedRetreatCost;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public String getFlavorText() {
		return flavor_text;
	}

	public void setFlavorText(String flavorText) {
		this.flavor_text = flavorText;
	}

	public String getNationalPokedexNumbers() {
		return national_pokedex_numbers;
	}

	public void setNationalPokedexNumbers(String nationalPokedexNumbers) {
		this.national_pokedex_numbers = nationalPokedexNumbers;
	}

	public String getLegalities() {
		return legalities;
	}

	public void setLegalities(String legalities) {
		this.legalities = legalities;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public String getRegulationMark() {
		return regulation_mark;
	}

	public void setRegulationMark(String regulationMark) {
		this.regulation_mark = regulationMark;
	}

	public String getAncientTrait() {
		return ancient_trait;
	}

	public void setAncientTrait(String ancientTrait) {
		this.ancient_trait = ancientTrait;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
}
