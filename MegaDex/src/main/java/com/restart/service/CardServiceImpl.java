package com.restart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.restart.entity.Card;
import com.restart.repository.CardRepository;
@Service
public class CardServiceImpl implements CardService{

	@Autowired
	private CardRepository dao;
	
	private static final int page_size = 100; //numero di carte per pagina

	
	@Cacheable("cards")
    public List<Card> getFilteredCards(String Id, String name, String supertype, String type, String subtype, String set, int page) {

        Specification<Card> spec = (root, query, cb) -> {
            List<jakarta.persistence.criteria.Predicate> predicates = new ArrayList<>();

            if (Id != null) {
                predicates.add(cb.equal(root.get("id"), Id));
            }
            if (name != null) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if (supertype != null) {
                predicates.add(cb.equal(cb.lower(root.join("supertype").get("name")), supertype.toLowerCase()));
            }
            if (type != null) {
                predicates.add(cb.equal(cb.lower(root.join("types").get("name")), type.toLowerCase()));
            }
            if (subtype != null) {
                predicates.add(cb.equal(cb.lower(root.join("subtypes").get("name")), subtype.toLowerCase()));
            }
            if (set != null) {
                predicates.add(cb.equal(cb.lower(root.get("set")), set.toLowerCase()));
            }

            return cb.and(predicates.toArray(new jakarta.persistence.criteria.Predicate[0]));
        };

        Pageable pageable = PageRequest.of(page - 1, page_size);  // Correct Pageable type
        return dao.findAll(spec, pageable).getContent();
    }
	
	/*	@Cacheable("cards")
	public List<Card> getFilteredCards(String Id, String name, String supertype, String type, String subtype, String set, int page) {
        List<Card> allCards = dao.findAll();
        
        return allCards.stream()
            .filter(card -> { //filtro per vari campi, se non vi è dato un parametro va al campo successivo finchè non esauriscono
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
            .skip((page - 1) * page_size) // sottraggo 1 per partire dalla pagina 1
            .limit(page_size) // limite di carte per pagina
            .collect(Collectors.toList()); //"Colleziona" i risultati nella lista
    }
	*/
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


	
}
