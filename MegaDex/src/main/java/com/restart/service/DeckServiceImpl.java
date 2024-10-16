package com.restart.service;

import java.util.List;
import java.util.Optional;

import com.restart.entity.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restart.repository.DeckRepository;

@Service
public class DeckServiceImpl implements DeckService {

    @Autowired
    private DeckRepository deckRepo;

    // Recupera tutti i mazzi dal database
    @Override
    public List<Deck> getDecks() {
        return deckRepo.findAll();
    }

    // Recupera i mazzi con un nome specifico
    @Override
    public List<Deck> getDecksByName(String name) {
        return deckRepo.findByName(name);
    }

    // Salva un nuovo mazzo nel database
    @Override
    public Deck saveDeck(Deck deck) {
        return deckRepo.save(deck);
    }

    // Elimina un mazzo dal database
    @Override
    public void removeDeck(Deck deck) {
        deckRepo.delete(deck);
    }

    // Recupera un mazzo specifico tramite il suo ID
    @Override
    public Optional<Deck> getDeckById(Integer id) {
        return deckRepo.findById(id);
    }

}