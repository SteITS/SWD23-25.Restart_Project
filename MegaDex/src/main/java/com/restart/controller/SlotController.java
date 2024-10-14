package com.restart.controller;

import com.restart.entity.Card;
import com.restart.entity.Deck;
import com.restart.entity.DeckPass;
import com.restart.entity.Slot;
import com.restart.service.CardServiceImpl;
import com.restart.service.SlotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
// Controller for managing slots in a deck
public class SlotController {
    @Autowired
    private SlotServiceImpl slotService;
    @Autowired
    private CardServiceImpl cardService;

    @PostMapping("/validateSlots")
    public DeckPass validateDeck(@RequestBody List<Slot> slots) {
        for(Slot slot : slots) {
            slot.setCard(cardService.getCardById(slot.getId().getIdCard())
                    .orElseThrow(() -> new RuntimeException("Card not found with ID: " + slot.getId().getIdCard())));
        }
        return slotService.validateSlots(slots);
    }
}
