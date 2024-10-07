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
	
	@GetMapping("/cards")
    public ResponseEntity<List<Card>> getFilteredCards(
    	@RequestParam(required = false) String Id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String supertype,
        @RequestParam(required = false) String type,
        @RequestParam(required = false) String subtype,
        @RequestParam(required = false) String set) {

        List<Card> filteredCards = service.getFilteredCards(Id, name, supertype, type, subtype, set);
        return new ResponseEntity<>(filteredCards, HttpStatus.OK);
    }
	
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
	
	
}
