package com.restart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="slots")
public class Slot {
	
	@EmbeddedId
	private SlotId id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idCard")
	@JoinColumn(name="id_card", referencedColumnName = "id", nullable = false)
	private Card card;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idDeck")
	@JoinColumn(name = "id_deck",referencedColumnName = "id", nullable = false )
	private Deck deck;
	
	@Column(name="quantity", nullable = false)
	private int quantity;
	
	

}
