package com.restart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restart.entity.Deck;
import com.restart.entity.User;

@Repository
public interface DeckRepository extends JpaRepository<Deck, Integer>{

	List<Deck> findByName(String name);
	
	List<Deck> findByUser(User user);
	
}
