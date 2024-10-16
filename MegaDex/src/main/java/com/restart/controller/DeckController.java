package com.restart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
import java.util.Map;

import com.restart.entity.DeckPass;
import com.restart.entity.Deck;
import com.restart.entity.User;
import com.restart.entity.Slot;
import com.restart.service.DeckServiceImpl;
import com.restart.service.UserServiceImpl;
import com.restart.service.CardServiceImpl;
import com.restart.service.SlotServiceImpl;

@RestController
@RequestMapping("/api")
public class DeckController {
	
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private DeckServiceImpl deckService;
	@Autowired
  	private SlotServiceImpl slotService;
  @Autowired
  private CardServiceImpl cardService;
  
  @PostMapping("/auth/decksByUser")
  public ResponseEntity<List<Deck>> getDecksByUserId(@RequestBody Map<String, Integer> requestBody) {
      // Extract user ID from request body
      int userId = requestBody.get("userId");

      // Find the user by ID
      User user = userService.findUserById(userId)
              .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

      // Fetch the decks associated with the user
      List<Deck> decks = deckService.getDecksByUser(user);

      return ResponseEntity.ok(decks);
  }
  
	@PostMapping("/auth/addDeck")
	public ResponseEntity<Deck> addDeck(@RequestBody Deck deck){
		//Recupera utente autenticato
		User user = userService.getAuthenticatedUser();
		deck.setUser(user);

		//Associa la lista di slot se esistente
		if(deckService.getDeckById(deck.getId()).isPresent()){
				if(deckService.getDeckById(deck.getId()).get().getUser() != user){
					throw new RuntimeException("Id Deck not matching its owner");
				}
            deck.setSlots(deckService.getDeckById(deck.getId()).get().getSlots());
        }

        //Salva il deck
        Deck newDeck = deckService.saveDeck(deck);
        return ResponseEntity.ok(newDeck);
	}
	
//Rimuove un deck
	@PostMapping("/deb/removeDeck")
	public ResponseEntity<String> removeDeck(@RequestBody Deck deck){
		//Recupera utente autenticato
		User user = userService.getAuthenticatedUser();
		deck.setUser(user);

		//Controlla che il proprietario sia quello giusto
		if(deckService.getDeckById(deck.getId()).isPresent()
				&& deckService.getDeckById(deck.getId()).get().getUser() != user){
					throw new RuntimeException("Id Deck not matching its owner");
		}

		//Rimuove il deck
		try {
			deckService.removeDeck(deck);
			return ResponseEntity.ok("Deck erased successfully");
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}

	//Valida il set di un deck secondo il regolamento
	@PostMapping("/deb/validateDeck")
    public DeckPass validateDeck(@RequestBody List<Slot> deck) {
      //Associa le carte al deck
		for(Slot slot : deck) {
            slot.setCard(cardService.getCardById(slot.getId().getIdCard())
                    .orElseThrow(() -> new RuntimeException("Card not found with ID: " + slot.getId().getIdCard())));
        }  
      //Esegue la validazione del deck e ritorna un DeckPass
		return slotService.validateSlots(deck);
    }
}
