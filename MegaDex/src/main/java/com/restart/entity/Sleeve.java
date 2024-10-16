package com.restart.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "sleeves")

public class Sleeve {
	
	//Id della sleeve generato con la classe SleeveId
    @EmbeddedId
    private SleeveId id;

    //Numero che indica la quantità di carte inserite nella sleeve
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    //Oggetto user a cui è associata la sleeve
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUser")
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    private User user;

    //Oggetto carta associata alla sleeve
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idCard")
    @JoinColumn(name = "id_card", referencedColumnName = "id", nullable = false)
    private Card card;

}