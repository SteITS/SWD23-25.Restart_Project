package com.restart.controller;

import com.restart.entity.Deck;
import com.restart.entity.DeckPass;
import com.restart.service.DeckService;
import com.restart.service.DeckServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class DeckController {
    @Autowired
    private DeckServiceImpl deckService;

    @PostMapping("/validateDeck")
    public CompletableFuture<DeckPass> validateDeck(@RequestBody Deck deck) {
        return deckService.validateDeckAsync(deck);
    }
}
