package com.restart.controller;

import com.restart.entity.Deck;
import com.restart.entity.DeckPass;
import com.restart.entity.Slot;
import com.restart.service.DeckService;
import com.restart.service.DeckServiceImpl;
import com.restart.service.SlotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class DeckController {
    @Autowired
    private DeckServiceImpl deckService;
    @Autowired
    private SlotServiceImpl slotService;

    @PostMapping("/validateDeck")
    public DeckPass validateDeck(@RequestBody List<Slot> deck) {
        return slotService.validateSlots(deck);
    }
}
