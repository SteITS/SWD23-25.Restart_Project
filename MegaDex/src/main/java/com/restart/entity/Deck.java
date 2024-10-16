package com.restart.entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="decks")
public class Deck {
	
	//Id dell'oggetto
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//Oggetto dell'utente a cui è associato il deck
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_user", referencedColumnName = "id", nullable = false)
	private User user;
	
	//Nome del deck
	@Column(name = "name", nullable = true, unique = true)
	private String name;
	
	//Descrizione del deck
	@Column(name = "description", nullable = true)
	private String description;
	
	//Lista degli slot delle carte inserite nel deck
	@OneToMany(mappedBy = "deck", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Slot> slots;
}

