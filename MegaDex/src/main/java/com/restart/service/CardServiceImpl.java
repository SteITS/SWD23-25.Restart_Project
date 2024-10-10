package com.restart.service;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.restart.dto.CardDto;
import com.restart.entity.Card;
import com.restart.repository.CardRepository;

//Implementation of the CardService interface that handles the logic
@Service
public class CardServiceImpl implements CardService{

	@Autowired
	private CardRepository dao;
	
	private static final int page_size = 100; //numero di carte per pagina

	

	public CardDto getFilteredCards(String Id, String name, String supertype, String type, String subtype, String set, int page, String orderBy, String direction) {
		// Builds dynamic filtering criteria using JPA Specifications
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

	    // Sort order logic
	    Sort sort;
	    if (direction.equalsIgnoreCase("asc")) {
	        sort = Sort.by(Sort.Order.asc(orderBy).ignoreCase()); // Case-insensitive ordering
	    } else {
	        sort = Sort.by(Sort.Order.desc(orderBy).ignoreCase()); // Case-insensitive ordering
	    }

	    // Defines pagination and sorting for the query (zero-based page index)
	    Pageable pageable = PageRequest.of(page - 1, page_size, sort); // Pageable with sorting
	    // Executes the query with the specifications, pagination, and sorting
	    Page<Card> cardPage = dao.findAll(spec, pageable);

	    // Creates and returns a CardDto object that contains the filtered cards and pagination info
	    return new CardDto(
	        cardPage.getContent(),             // List of filtered cards
	        page,                              // Current page number
	        cardPage.getTotalPages(),          // Total number of pages
	        cardPage.getTotalElements()        // Total number of items
	    );
	}
}
