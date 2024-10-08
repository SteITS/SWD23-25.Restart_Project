package com.restart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restart.entity.Card;
import com.restart.service.CardService;


@RestController
public class CardController {
	@Autowired
	private CardService service;
	
	//senza parametri sarà una lista di tutte le carte nel DB
	@GetMapping("/cards")
    public ResponseEntity<List<Card>> getFilteredCards(
    	@RequestParam(required = false) String Id,  //ricerca per Id
        @RequestParam(required = false) String name, //ricerca per nome
        @RequestParam(required = false) String supertype, //ricerca per per supertipo
        @RequestParam(required = false) String type,	//ricerca per per tipo
        @RequestParam(required = false) String subtype,	//ricerca per per sottotipo
        @RequestParam(required = false) String set,		//ricerca per per espansione
    	@RequestParam(defaultValue = "1") int page) // Inizia paginazione da 1
	{

		List<Card> filteredCards = service.getFilteredCards(Id, name, supertype, type, subtype, set, page); 
        return new ResponseEntity<>(filteredCards, HttpStatus.OK); //ritorna una lista di carte filtrate
    }
	
	
	//Da qui in poi sono filtri che funzionano solo uno per volta, non vengono utilizzati
	
	/*
	@GetMapping("/single")
	public ResponseEntity<List<Card>> getCards(){
		return new ResponseEntity<>(service.getCards(),HttpStatus.OK);
	}
	
	@GetMapping("/single/{name}")
	public List<Card> getCardsByName(@PathVariable String name) {
		return service.getCardsByName(name);
	}
	
	@GetMapping("/single/supertype={supertype}")
	public List<Card> getCardsBySupertype(@PathVariable String supertype) {
		return service.getCardsBySupertypeName(supertype);
	}
	
	@GetMapping("/single/type={type}")
	public List<Card> getCardsByType(@PathVariable String type) {
		return service.getCardsByType(type);
	}
	@GetMapping("/single/subtype={subtype}")
	public List<Card> getCardsBySubtype(@PathVariable String subtype) {
		return service.getCardsBySubtype(subtype);
	}
	@GetMapping("/single/set={set}")
	public List<Card> getCardsBySet(@PathVariable String set) {
		return service.getCardsBySet(set);
	}
	*/
}
