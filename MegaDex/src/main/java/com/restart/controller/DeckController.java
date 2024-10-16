package com.restart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restart.entity.Deck;
import com.restart.entity.User;
import com.restart.service.DeckServiceImpl;
import com.restart.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class DeckController {
	
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private DeckServiceImpl deckService;
	
	@PostMapping("/addDeck")
	public ResponseEntity<Deck> addDeck(@RequestBody Deck deck){
		
		//Gets the user from the database through the id sent with the request
		User user = userService.findUserById(deck.getUser().getId())
						.orElseThrow(() -> new RuntimeException("User not found with ID: " + deck.getUser().getId()));
		


		//Creates the new deck and sets the user associated to the deck
		deck.setUser(user);
		
		//Saves the new deck
		Deck newDeck = deckService.saveDeck(deck);
		return ResponseEntity.ok(newDeck);
	}
	
	@PostMapping("/removeDeck")
	public ResponseEntity<String> removeDeck(@RequestBody Deck deck){
		
		//Removes the deck
		try {
			deckService.removeDeck(deck);
			return ResponseEntity.ok("Deck eliminato con successo");
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
}
