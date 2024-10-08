package com.restart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restart.entity.*;
import com.restart.repository.DeckRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DeckServiceImpl implements DeckService{

	private DeckRepository deckRepo;
	private SlotServiceImpl slotService;

	@Override
	@Async
	public CompletableFuture<DeckPass> validateDeckAsync(Deck deck) {
		List<Slot> slots = deck.getSlots();
		DeckPass result = slotService.validateSlots(slots);
		return CompletableFuture.completedFuture(result);
	}


	@Override
	public List<Deck> getDecks() {
		return deckRepo.findAll();
	}

	@Override
	public List<Deck> getDecksByName(String name) {
		return deckRepo.findByName(name);
	}
	

}
