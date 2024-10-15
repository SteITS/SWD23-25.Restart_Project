package com.restart.service;

import java.util.List;

import com.restart.entity.Deck;

public interface DeckService {
	
	//Method to obtain a list of all the decks
	List<Deck> getDecks();
	
	//Method to obtain a specific deck by the name
	List<Deck> getDecksByName(String name);
	
	//Method to obtain a specific deck by id
	Deck getDeckById(Integer id);
	
	//Method to save a deck
	Deck saveDeck(Deck deck);
	
	//Method to remove a deck
	void removeDeck(Deck deck);
}
