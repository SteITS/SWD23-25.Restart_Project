package com.restart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ratings")
public class Rating {
	
	//Id dell'oggetto generato con la class RatingId
    @EmbeddedId
    private RatingId id;

    //Valore booleano del rating positivo o negativo
    @Column(name = "rate")
    private Boolean rate;

    //Oggetto dell'utente associato al rating
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUser")
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    private User user;

    //Oggetto del deck associato al rating
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idDeck")
    @JoinColumn(name = "id_deck", referencedColumnName = "id", nullable = false)
    private Deck deck;


}