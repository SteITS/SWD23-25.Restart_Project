package com.restart.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restart.entity.Card;
import com.restart.entity.DeckPass;
import com.restart.entity.Slot;
import com.restart.entity.Subtype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlotServiceImpl implements SlotService {
    public DeckPass validateSlots(List<Slot> slots) {
        DeckPass result = new DeckPass();
        ObjectMapper objectMapper = new ObjectMapper();

        result.quantityBalancing(slots.size());

        Map<String, Integer> cardCount = new HashMap<>();
        for (Slot slot : slots) {
            Card card = slot.getCard();

        }

        for (Slot slot : slots) {
            Card card = slot.getCard();
            String legalities = card.getLegalities();
            try {
                JsonNode legalitiesNode = objectMapper.readTree(legalities);
                String standardLegality = legalitiesNode.get("standard").asText();
                String expandedLegality = legalitiesNode.get("expanded").asText();
                String unlimitedLegality = legalitiesNode.get("unlimited").asText();

                // Carte bandite o limitate
                if (standardLegality.equals("Banned")) {
                    result.addStandardFormat(card);
                }
                if (expandedLegality.equals("Banned")) {
                    result.addExpandedFormat(card);
                }
                if (unlimitedLegality.equals("Banned")) {
                    result.addUnlimitedFormat(card);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


            // Formato del torneo
            if(result.getRegulationMark() == null){
                result.setRegulationMark(card.getRegulationMark());
            } else if(!result.getRegulationMark().equals(card.getRegulationMark()) && !result.getRegulationMark().equals("Unlimited")){
                result.setRegulationMark("Unlimited");
            }


            //Limite massimo di copie per carta
            String cardName = card.getName();
            for(Subtype subtype : card.getSubtypes()){
                if (!subtype.getName().equals("Energy")) { // Escludi le carte Energia base
                    cardCount.put(cardName, cardCount.getOrDefault(cardName, 0) + 1);
                }
            }

        }
        for (Map.Entry<String, Integer> entry : cardCount.entrySet()) {
            if (entry.getValue() > 4) {
                for (Slot slot : slots) {
                    if (slot.getCard().getName().equals(entry.getKey())) {
                        result.addTooMany(slot.getCard());
                    }
                }
            }
        }

        return result;
    }
}
