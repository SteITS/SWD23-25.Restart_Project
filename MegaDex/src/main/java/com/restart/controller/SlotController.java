package com.restart.controller;

import java.util.List;
import com.restart.entity.Card;
import com.restart.entity.Deck;
import com.restart.entity.Slot;
import com.restart.service.CardServiceImpl;
import com.restart.service.SlotServiceImpl;
import com.restart.service.DeckServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class SlotController {
	
	@Autowired
	private SlotServiceImpl slotService;
	@Autowired
	private CardServiceImpl cardService;
	@Autowired
	private DeckServiceImpl deckService;
	
	
	//Aggiorna o rimuove uno slot
	@PostMapping("/auth/updateSlot")
	public ResponseEntity<Slot> addSlot(@RequestBody Slot slotRequest){

		// Recupera il deck dal database usando l'ID passato nella richiesta
		Deck deck = deckService.getDeckById(slotRequest.getId().getIdDeck())
				.orElseThrow(() -> new RuntimeException("Card not found with ID: " + slotRequest.getId().getIdCard()));;
		Card card = cardService.getCardById(slotRequest.getId().getIdCard())
				.orElseThrow(() -> new RuntimeException("Card not found with ID: " + slotRequest.getId().getIdCard()));


		// Associa carta e deck
		slotRequest.setDeck(deck);
		slotRequest.setCard(card);


		// Salva lo slot se la quantità è maggiore di 0
		if(slotRequest.getQuantity()>0){
			Slot savedSlot = slotService.addSlot(slotRequest);
			return ResponseEntity.ok(savedSlot);
		}
		//altrimenti lo rimuove
		else {
			slotService.removeSlot(slotRequest);
			return ResponseEntity.ok(slotRequest);
		}

	}
	
	//Rimuove uno slot
	@PostMapping("/auth/removeSlot")
	public ResponseEntity<String> removeSlot(@RequestBody Slot slotRequest){
		// Recupera il deck e la carta dal database
		Deck deck = deckService.getDeckById(slotRequest.getId().getIdDeck())
				.orElseThrow(() -> new RuntimeException("Deck not found with ID: " + slotRequest.getId().getIdDeck()));;
		Card card = cardService.getCardById(slotRequest.getId().getIdCard())
				.orElseThrow(() -> new RuntimeException("Card not found with ID: " + slotRequest.getId().getIdCard()));

		// Associa carta e deck
		slotRequest.setDeck(deck);
		slotRequest.setCard(card);

		try {
            slotService.removeSlot(slotRequest);
            return ResponseEntity.ok("Slot eliminato con successo");
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
	}

	//Aggiunge una lista di slot
	@PostMapping("/auth/saveSlots")
	public ResponseEntity<List<Slot>> addSlots(@RequestBody List<Slot> slotsRequest){
		for(Slot slot : slotsRequest){
			addSlot(slot);
		}
	return ResponseEntity.ok(slotsRequest);
	}

}
