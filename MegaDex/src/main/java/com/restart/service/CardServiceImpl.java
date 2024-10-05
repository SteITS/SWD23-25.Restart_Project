package com.restart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restart.entity.Card;
import com.restart.repository.CardRepository;
@Service
public class CardServiceImpl implements CardService{

	@Autowired
	private CardRepository dao;
	
	@Override
	public List<Card> getCardsByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public List<Card> getCards() {
		return dao.findAll();
	}

	@Override
	public List<Card> getCardsBySupertypeName(String name) {
		return dao.findBySupertypeName(name);
	}

	@Override
    public List<Card> getCardsByType(String name) {
        return dao.findByTypes_Name(name);
    }

	@Override
	public List<Card> getCardsBySubtype(String name) {
		return dao.findBySubtypes_Name(name);
	}


	
}
