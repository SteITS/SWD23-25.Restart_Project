package com.restart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
@Getter
@Setter
@Embeddable
public class SleeveId implements Serializable {
	
	//Id dell'utente associato alla collezione privata (sleeve)
    @Column(name = "id_user", nullable = false)
    private Integer idUser;

    //Id della carta associata alla collezione privata (sleeve)
    @Nationalized
    @Column(name = "id_card", nullable = false, length = 50)
    private String idCard;

    //Metodi equals e hashcode per gestire i tipi
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SleeveId entity = (SleeveId) o;
        return Objects.equals(this.idUser, entity.idUser) &&
                Objects.equals(this.idCard, entity.idCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idCard);
    }

}