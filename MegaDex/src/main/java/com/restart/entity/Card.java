package com.restart.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @Nationalized
    @Column(name = "id", nullable = false, length = 50)
    private String id;

    @Nationalized
    @Column(name = "expansion", nullable = false, length = 50)
    private String expansion;

    @Nationalized
    @Column(name = "series", nullable = false, length = 50)
    private String series;


    @Nationalized
    @Column(name = "publisher", nullable = false, length = 50)
    private String publisher;


    @Nationalized
    @Column(name = "generation", nullable = false, length = 50)
    private String generation;


    @Nationalized
    @Column(name = "release_date", nullable = false, length = 50)
    private String releaseDate;


    @Nationalized
    @Column(name = "artist", length = 50)
    private String artist;


    @Nationalized
    @Column(name = "name", nullable = false, length = 100)
    private String name;


    @Nationalized
    @Column(name = "set_num", nullable = false, length = 50)
    private String setNum;


    @Nationalized
    @Column(name = "card_level", length = 3)
    private String cardLevel;

    @Column(name = "hp")
    private Integer hp;


    @Nationalized
    @Column(name = "evolves_from", length = 50)
    private String evolvesFrom;


    @Nationalized
    @Column(name = "evolves_to", length = 100)
    private String evolvesTo;


    @Nationalized
    @Column(name = "retreat_cost", length = 100)
    private String retreatCost;


    @Nationalized
    @Column(name = "converted_retreat_cost", length = 50)
    private String convertedRetreatCost;


    @Nationalized
    @Column(name = "rarity", length = 50)
    private String rarity;

    @Nationalized
    @Lob
    @Column(name = "flavor_text")
    private String flavorText;


    @Nationalized
    @Column(name = "national_pokedex_numbers", length = 50)
    private String nationalPokedexNumbers;


    @Nationalized
    @Lob
    @Column(name = "legalities", nullable = false)
    private String legalities;

    @Nationalized
    @Lob
    @Column(name = "rules")
    private String rules;


    @Nationalized
    @Column(name = "regulation_mark", length = 1)
    private String regulationMark;

    @Nationalized
    @Lob
    @Column(name = "ancient_trait")
    private String ancientTrait;

    @Nationalized
    @Lob
    @Column(name = "img")
    private String img;

}