package com.restart.service;

import java.util.List;

import com.restart.entity.Card;

public interface CardService {

	List<Card> getFilteredCards(String Id,String name, String supertype, String type, String subtype, String set, int page);

	List<Card> getCardsByName(String name);

	List<Card> getCards();

	List<Card> getCardsBySupertypeName(String name);
	
	List<Card> getCardsByType(String name);
	
	List<Card> getCardsBySubtype(String name);
	
	List<Card> getCardsBySet(String name);
	
}
