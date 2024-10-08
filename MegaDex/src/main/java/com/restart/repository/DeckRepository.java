package com.restart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restart.entity.Deck;

@Repository
public interface DeckRepository extends JpaRepository<Deck, Integer>{

	List<Deck> findAll();
	List<Deck> findByName(String name);
}
