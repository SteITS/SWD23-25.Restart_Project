package com.restart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restart.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restart.repository.DeckRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

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

	//Implementations of the method to remove a deck from the database
	@Override
	public void removeDeck(Deck deck) {
		deckRepo.delete(deck);
	}
	

}
