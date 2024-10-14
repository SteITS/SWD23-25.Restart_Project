package com.restart.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restart.entity.Card;
import com.restart.repository.CardRepository;
@Service
public class CardServiceImpl implements CardService{

	@Autowired
	private CardRepository dao;
	
	public List<Card> getFilteredCards(String Id, String name, String supertype, String type, String subtype, String set) {
        List<Card> allCards = dao.findAll();
        
        return allCards.stream()
            .filter(card -> {
            	if (Id != null && !card.getId().equals(Id)) {
                    return false;
                }
            	if (name != null && !card.getName().toLowerCase().contains(name.toLowerCase())) {
                    return false;
                }
                if (supertype != null && (card.getSupertype() == null || !card.getSupertype().getName().equalsIgnoreCase(supertype))) {
                    return false;
                }
                if (type != null && card.getTypes().stream().noneMatch(t -> t.getName().equalsIgnoreCase(type))) {
                    return false;
                }
                if (subtype != null && card.getSubtypes().stream().noneMatch(st -> st.getName().equalsIgnoreCase(subtype))) {
                    return false;
                }
                if (set != null && !card.getSet().equalsIgnoreCase(set)) {
                    return false;
                }
                return true;
            })
            .collect(Collectors.toList());
    }
	
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

	@Override
	public List<Card> getCardsBySet(String name) {
		return dao.findBySet(name);
	}

	public Optional<Card> getCardById(String id) {
		return dao.findById(id);
	}


	
}
