package com.restart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository dao;

    private static final int PAGE_SIZE = 15;  // Dimensione pagina per la ricerca filtrata (modificabile)

    //Metodo per ricercare tutte le carte secondo uno o più specifici filtri
    public CardDto getFilteredCards(String id, String name, String supertype, String type, String subtype, String set, int page, String orderBy, String direction) {
        // Specifica per la creazione di un filtro di ricerca JPA
        Specification<Card> spec = (root, query, cb) -> {
            List<jakarta.persistence.criteria.Predicate> predicates = new ArrayList<>();

            if (id != null) {
                predicates.add(cb.equal(root.get("id"), id));
            }
            if (name != null) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if (supertype != null && !supertype.isEmpty()) {
                predicates.add(cb.equal(cb.lower(root.join("supertype").get("name")), supertype.toLowerCase()));
            }
            if (type != null && !type.isEmpty()) {
                predicates.add(cb.equal(cb.lower(root.join("types").get("name")), type.toLowerCase()));
            }
            if (subtype != null && !subtype.isEmpty()) {
                predicates.add(cb.equal(cb.lower(root.join("subtypes").get("name")), subtype.toLowerCase()));
            }
            if (set != null && !set.isEmpty()) {
                predicates.add(cb.equal(cb.lower(root.get("set")), set.toLowerCase()));
            }

            return cb.and(predicates.toArray(new jakarta.persistence.criteria.Predicate[0]));
        };

        // Ordinamento della pagina dei risultati
        Sort sort;
        if (direction.equalsIgnoreCase("asc")) {
            sort = Sort.by(Sort.Order.asc(orderBy).ignoreCase());
        } else {
            sort = Sort.by(Sort.Order.desc(orderBy).ignoreCase());
        }

        // Configurazione della paginazione
        Pageable pageable = PageRequest.of(page - 1, PAGE_SIZE, sort);  // Pagina 0-based

        // Recupera la pagina di carte filtrate
        Page<Card> cardPage = dao.findAll(spec, pageable);

        // Crea e restituisce un oggetto CardDto con i risultati e le informazioni di paginazione
        return new CardDto(
                cardPage.getContent(),
                page,
                cardPage.getTotalPages(),
                cardPage.getTotalElements()
        );
    }

    // Recupera una carta specifica tramite il suo ID
    public Optional<Card> getCardById(String id) {
        return dao.findById(id);
    }
}