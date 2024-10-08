package com.restart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Nationalized;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class SleeveId implements Serializable {
    @Column(name = "id_user", nullable = false)
    private Integer idUser;

    @Nationalized
    @Column(name = "id_card", nullable = false, length = 50)
    private String idCard;

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