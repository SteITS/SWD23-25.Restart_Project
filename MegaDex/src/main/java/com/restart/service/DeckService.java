package com.restart.service;

import java.util.List;

import com.restart.entity.Deck;

public interface DeckService {
	
	List<Deck> getDecks();
	
	List<Deck> getDecksByName(String name);
	
}
