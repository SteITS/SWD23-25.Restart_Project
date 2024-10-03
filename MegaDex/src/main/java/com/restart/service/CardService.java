package com.restart.service;

import java.util.List;

import com.restart.entity.Card;

public interface CardService {

	List<Card> getCardsByName(String name);
	
}
