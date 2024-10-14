package com.restart.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.restart.entity.Deck;
import com.restart.entity.DeckPass;

public interface DeckService {
	List<Deck> getDecks();
	List<Deck> getDecksByName(String name);
	
}
