package com.restart.entity;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "cards")
public class Card {

	@Id
	@Column(name = "id", nullable = false, length = 50)
	private String id;
	@Column(name = "expansion", length = 50)
	private String set;
	@Column(name = "series", length = 50)
	private String series;
	@Column(name = "publisher", length = 10)
	private String publisher;
	@Column(name = "generation", length = 15)
	private String generation;
	@Column(name = "release_date", length = 50)
	private String release_date;
	@Column(name = "artist", length = 50)
	private String artist;
	@Column(name = "name", length = 70)
	private String name;
	
	private String set_num;
	
	@Column(name = "card_level", length = 5)
	private String level;
	@Column(name = "hp", length = 5)
	private String hp;
	@Column(name = "evolves_from", length = 70)
	private String evolves_from;
	@Column(name = "evolves_to", length = 70)
	private String evolves_to;
	@Column(name = "retreat_cost", length = 70)
	private String retreat_cost;
	@Column(name = "converted_retreat_cost", length = 5)
	private String converted_retreat_cost;
	@Column(name = "rarity", length = 50)
	private String rarity;
	
	private String flavor_text;
	@Column(name = "national_pokedex_numbers", length = 50)
	private String national_pokedex_numbers;
	@Column(name = "legalities", length = 100)
	private String legalities;
	
	private String rules;
	@Column(name = "regulation_mark", length = 50)
	private String regulation_mark;
	@Column(name = "ancient_trait", length = 50)
	private String ancient_trait;
	
	private String img;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "card_attacks",
			joinColumns = @JoinColumn(name="card_id"),
			inverseJoinColumns = @JoinColumn(name="attack_id")
	)
	@JsonManagedReference
	private Set<Attack> attacks;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "card_abilities",
			joinColumns = @JoinColumn(name="card_id"),
			inverseJoinColumns = @JoinColumn(name="ability_id")
			)
	@JsonManagedReference
	private Set<Ability> abilities;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "card_weaknesses",
			joinColumns = @JoinColumn(name="card_id"),
			inverseJoinColumns = @JoinColumn(name="weakness_id")
			)
	@JsonManagedReference
	private Set<Weakness> weaknesses;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "card_resistances",
			joinColumns = @JoinColumn(name="card_id"),
			inverseJoinColumns = @JoinColumn(name="resistance_id")
			)
	@JsonManagedReference
	private Set<Resistance> resistances;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "card_types",
			joinColumns = @JoinColumn(name="card_id"),
			inverseJoinColumns = @JoinColumn(name="type_id")
			)
	@JsonManagedReference
	private Set<Type> types;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "card_subtypes",
			joinColumns = @JoinColumn(name="card_id"),
			inverseJoinColumns = @JoinColumn(name="subtype_id")
			)
	@JsonManagedReference
	private Set<Subtype> subtypes;
	
	@ManyToOne
    @JoinColumn(name = "supertype")
	@JsonManagedReference
    private Supertype supertype;
	
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


	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
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

	public String getEvolves_from() {
		return evolves_from;
	}

	public void setEvolves_from(String evolves_from) {
		this.evolves_from = evolves_from;
	}

	public String getEvolves_to() {
		return evolves_to;
	}

	public void setEvolves_to(String evolves_to) {
		this.evolves_to = evolves_to;
	}

	public String getRetreat_cost() {
		return retreat_cost;
	}

	public void setRetreat_cost(String retreat_cost) {
		this.retreat_cost = retreat_cost;
	}

	public String getConverted_retreat_cost() {
		return converted_retreat_cost;
	}

	public void setConverted_retreat_cost(String converted_retreat_cost) {
		this.converted_retreat_cost = converted_retreat_cost;
	}

	public String getFlavor_text() {
		return flavor_text;
	}

	public void setFlavor_text(String flavor_text) {
		this.flavor_text = flavor_text;
	}

	public String getNational_pokedex_numbers() {
		return national_pokedex_numbers;
	}

	public void setNational_pokedex_numbers(String national_pokedex_numbers) {
		this.national_pokedex_numbers = national_pokedex_numbers;
	}

	public String getRegulation_mark() {
		return regulation_mark;
	}

	public void setRegulation_mark(String regulation_mark) {
		this.regulation_mark = regulation_mark;
	}

	public String getAncient_trait() {
		return ancient_trait;
	}

	public void setAncient_trait(String ancient_trait) {
		this.ancient_trait = ancient_trait;
	}

	public Set<Attack> getAttacks() {
		return attacks;
	}

	public void setAttacks(Set<Attack> attacks) {
		this.attacks = attacks;
	}

	public Set<Ability> getAbilities() {
		return abilities;
	}

	public void setAbilities(Set<Ability> abilities) {
		this.abilities = abilities;
	}

	public Set<Weakness> getWeaknesses() {
		return weaknesses;
	}

	public void setWeaknesses(Set<Weakness> weaknesses) {
		this.weaknesses = weaknesses;
	}

	public Set<Resistance> getResistances() {
		return resistances;
	}

	public void setResistances(Set<Resistance> resistances) {
		this.resistances = resistances;
	}

	public Set<Type> getTypes() {
		return types;
	}

	public void setTypes(Set<Type> types) {
		this.types = types;
	}

	public Set<Subtype> getSubtypes() {
		return subtypes;
	}

	public void setSubtypes(Set<Subtype> subtypes) {
		this.subtypes = subtypes;
	}

	public Supertype getSupertype() {
		return supertype;
	}

	public void setSupertype(Supertype supertype) {
		this.supertype = supertype;
	}
	
}

