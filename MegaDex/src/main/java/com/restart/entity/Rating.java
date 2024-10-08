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
    @EmbeddedId
    private SleeveId id;

    @Column(name = "rate")
    private Boolean rate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUser")
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idDeck")
    @JoinColumn(name = "id_deck", referencedColumnName = "id", nullable = false)
    private Deck deck;


}