package com.restart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class RatingId implements Serializable {
    private static final long serialVersionUID = 3472128162887018L;

    //Id dell'utente associato al rating
    @Column(name = "id_user", nullable = false)
    private Integer idUser;

    //Id del deck associato al rating
    @Nationalized
    @Column(name = "id_deck", nullable = false, length = 50)
    private Integer idDeck;

    //Metodi equals e hashcode per la gestione dei tipi
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RatingId entity = (RatingId) o;
        return Objects.equals(this.idUser, entity.idUser) &&
                Objects.equals(this.idDeck, entity.idDeck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idDeck);
    }

}