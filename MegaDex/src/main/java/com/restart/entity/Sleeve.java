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
    @EmbeddedId
    private SleeveId id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUser")
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idCard")
    @JoinColumn(name = "id_card", referencedColumnName = "id", nullable = false)
    private Card card;

}