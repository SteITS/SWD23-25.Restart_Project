package com.restart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.restart.entities.Card;
import com.restart.services.CardService;


@RestController
public class CardRest {
	@Autowired
	private CardService service;
	
	
	@GetMapping("/cards")
	public ResponseEntity<List<Card>> getCards(){
		return new ResponseEntity<>(service.getCards(),HttpStatus.OK);
	}
	
	@GetMapping("/cards/{name}")
	public List<Card> getCardsByName(@PathVariable String name) {
		return service.getCardsByName(name);
	}
	
}
