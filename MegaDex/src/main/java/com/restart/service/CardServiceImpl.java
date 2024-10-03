package com.restart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restart.entity.Card;
import com.restart.repository.CardDAO;
@Service
public class CardServiceImpl implements CardService{

	@Autowired
	private CardDAO dao;
	
	
	@Override
	public List<Card> getCardsByName(String name) {
		return dao.findByName(name);
	}


	
}
