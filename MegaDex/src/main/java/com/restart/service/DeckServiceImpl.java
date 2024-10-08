package com.restart.service;

import java.util.List;

import com.restart.entity.Deck;
import com.restart.repository.DeckRepository;

public class DeckServiceImpl implements DeckService{

	private DeckRepository deckRepo;
	
	@Override
	public List<Deck> getDecks() {
		return deckRepo.findAll();
	}

	@Override
	public List<Deck> getDecksByName(String name) {
		return deckRepo.findByName(name);
	}
	

}
