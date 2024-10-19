package com.restart.repository;

import com.restart.entity.Sleeve;
import com.restart.entity.SleeveId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SleeveRepository extends JpaRepository<Sleeve, SleeveId> {

	// Recupera tutte le sleeves associate a uno specifico ID utente
    List<Sleeve> findByUserId(int userId);
}
