package com.restart.service;

import java.util.List;
import java.util.Optional;
import com.restart.entity.Deck;

public interface DeckService {	

	List<Deck> getDecks();
	
	List<Deck> getDecksByName(String name);
	
	Optional<Deck> getDeckById(Integer id);
	
	Deck saveDeck(Deck deck);
	
	void removeDeck(Deck deck);
}
