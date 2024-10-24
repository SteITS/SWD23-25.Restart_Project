package com.restart.service;

import com.restart.dto.CardDto;
import com.restart.entity.Card;

import java.util.Optional;

public interface CardService {
	Optional<Card> getCardById(String id);

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
    		Boolean owned,
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
