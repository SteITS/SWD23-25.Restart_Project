package com.restart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restart.entity.Deck;
import com.restart.repository.DeckRepository;

@Service
public class DeckServiceImpl implements DeckService{

	@Autowired
	private DeckRepository deckRepo;
	
	//Implementation of the method to get all the decks from the database
	@Override
	public List<Deck> getDecks() {
		return deckRepo.findAll();
	}
	//Implementation of the method to get a single deck by name from the database
	@Override
	public List<Deck> getDecksByName(String name) {
		return deckRepo.findByName(name);
	}

	//Implementation of the method to save a deck in the database
	@Override
	public Deck saveDeck(Deck deck) {
		return deckRepo.save(deck);
	}

	//Implementation of the method to remove a deck from the database
	@Override
	public void removeDeck(Deck deck) {
		deckRepo.delete(deck);
	}
	
	//Implementation of the method to find a deck with the id
	@Override
	public Deck getDeckById(Integer id) {
		deckRepo.getReferenceById(id);
		return null;
	}
	

}
