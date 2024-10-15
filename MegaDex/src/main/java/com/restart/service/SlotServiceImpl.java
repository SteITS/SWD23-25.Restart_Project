package com.restart.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restart.entity.Card;
import com.restart.entity.DeckPass;
import com.restart.entity.Slot;
import com.restart.entity.Subtype;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SlotServiceImpl implements SlotService {

    public DeckPass validateSlots(List<Slot> slots) {
        DeckPass result = new DeckPass();
        ObjectMapper objectMapper = new ObjectMapper();
        int deckSize = 0;

        Map<String, Integer> cardCount = new HashMap<>();

        for (Slot slot : slots) {
            deckSize += slot.getQuantity();
            Card card = slot.getCard();
            String legalities = card.getLegalities();

            //controllo ban nei formati
            try {JsonNode legalitiesNode = objectMapper.readTree(legalities);
                String unlimitedLegality = legalitiesNode.get("unlimited").asText();
                if (unlimitedLegality.equals("Banned")) {
                    result.addUnlimitedFormat(card);
                }} catch (Exception e) {
                e.printStackTrace();
            }

            try{JsonNode legalitiesNode = objectMapper.readTree(legalities);
                String standardLegality = legalitiesNode.get("standard").asText();
                if (standardLegality.equals("Banned")) {
                    result.addStandardFormat(card);
                }} catch(Exception e){e.printStackTrace();}

            try{JsonNode legalitiesNode = objectMapper.readTree(legalities);
                String expandedLegality = legalitiesNode.get("expanded").asText();
                if (expandedLegality.equals("Banned")) {
                    result.addExpandedFormat(card);
                }} catch(Exception e){e.printStackTrace();}


            // Formato del torneo
            if(!result.getRegulationMarks().contains(card.getRegulation_mark()) && card.getRegulationMark()!=null){
                result.addRegulationMark(card.getRegulation_mark());
            }


            //Limite massimo di copie per carta
            String cardName = card.getName();
            for(Subtype subtype : card.getSubtypes()){
                if (!subtype.getName().equals("Energy")) { // Escludi le carte Energia base
                    cardCount.put(cardName, cardCount.getOrDefault(cardName, 0) + slot.getQuantity());
                }
            }

        }
        for (Map.Entry<String, Integer> entry : cardCount.entrySet()) {
            if (entry.getValue() > 4) {
                for (Slot slot : slots) {
                    if (slot.getCard().getName().equals(entry.getKey()) && !result.getTooMany().contains(slot.getCard().getName())) {
                        result.addTooMany(slot.getCard().getName());
                    }
                }
            }
        }

        result.quantityBalancing(deckSize);

        return result;
    }
}
