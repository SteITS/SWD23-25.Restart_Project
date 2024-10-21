package com.restart.controller;



import com.restart.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restart.dto.CardDto;
import com.restart.service.CardService;

// REST controller per gestire le richieste relative al recupero delle carte
@RestController
public class CardController {
	@Autowired
	private CardService service;

    // Parametri opzionali per i filtri: Id, name, supertype, type, subtype, set, page, orderBy, direction
    // Restituisce le prime 100 voci con o senza filtri applicati; i parametri 'page' permettono di scorrere tra i risultati
    @GetMapping("/cards")
    public ResponseEntity<CardDto> getFilteredCards(
        @RequestParam(required = false) String Id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String supertype,
        @RequestParam(required = false) String type,
        @RequestParam(required = false) String subtype,
        @RequestParam(required = false) String set,
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "Id") String orderBy,
        @RequestParam(defaultValue = "asc") String direction) 
    {

        // Chiama il servizio per recuperare le carte filtrate e i dati di paginazione
        CardDto response = service.getFilteredCards(Id, name, supertype, type, subtype, set, page, orderBy, direction);
        // Restituisce la risposta con lo stato HTTP 200 (OK)
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping("/api/auth/filtered-in-sleeves")
    public ResponseEntity<CardDto> getFilteredCardsInMySleeves(
            @RequestParam(required = false) String id, 
            @RequestParam(required = false) String name, 
            @RequestParam(required = false) String supertype,
            @RequestParam(required = false) String type, 
            @RequestParam(required = false) String subtype, 
            @RequestParam(required = false) String set, 
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "name") String orderBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(required = false) Boolean owned
    ) {
        // Get the filtered cards that are in the authenticated user's sleeves
        CardDto filteredCardsInSleeves = service.getFilteredCardsInMySleeves(owned, id, name, supertype, type, subtype, set, page, orderBy, direction);

        // Return the filtered cards in sleeves as a ResponseEntity
        return ResponseEntity.ok(filteredCardsInSleeves);
    }

    @GetMapping("api/deb/cardById")
    public ResponseEntity<Card> getCardById(@RequestParam String id) {
        Card card = service.getCardById(id).orElseThrow();
        return ResponseEntity.ok(card);
    }
}
	
	

