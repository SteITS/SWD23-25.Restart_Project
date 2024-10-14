package com.restart.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restart.dto.CardDto;
import com.restart.service.CardService;

//REST controller that handles requests related to card retrieval
@RestController
public class CardController {
	@Autowired
	private CardService service;
	
	//optional parameters for filters: Id,name,supertype,type,subtype,set,page,orderby,direction
	//returns first 100 entries with or without filters applied, page parameters to scroll through
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
		
		// Calls the service to retrieve the filtered cards and pagination data
        CardDto response = service.getFilteredCards(Id, name, supertype, type, subtype, set, page, orderBy, direction);
        // Returns the response with HTTP status 200 (OK)
        return new ResponseEntity<>(response, HttpStatus.OK); // Return the response with pagination info
    }
}
	
	

