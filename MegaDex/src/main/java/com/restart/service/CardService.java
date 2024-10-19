package com.restart.service;

import com.restart.dto.CardDto;

public interface CardService {

    CardDto getFilteredCards(
    		String Id,
    		String name,
    		String supertype,
    		String type,
    		String subtype,
    		String set,
    		int page,
    		String orderBy,
    		String direction
    );	
    CardDto getFilteredCardsInMySleeves(
    		String Id,
    		String name,
    		String supertype,
    		String type,
    		String subtype,
    		String set,
    		int page,
    		String orderBy,
    		String direction
    );
}
