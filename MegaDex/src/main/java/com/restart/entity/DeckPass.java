package com.restart.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DeckPass {
    private Integer cardExcess;
    private String regulationMark;
    private List<Card> tooMany;
    private List<Card> standardFormat;
    private List<Card> expandedFormat;
    private List<Card> unlimitedFormat;

    public DeckPass() {
        this.tooMany = new ArrayList<>();
        this.standardFormat = new ArrayList<>();
        this.expandedFormat = new ArrayList<>();
    }

    public void addTooMany(Card carta) {
        this.tooMany.add(carta);
    }

    public void quantityBalancing(Integer deckQuantity) {
        this.cardExcess = 60-deckQuantity;
    }

    public void addStandardFormat(Card card) {
        this.standardFormat.add(card);
    }

    public void addExpandedFormat(Card card) {
        this.expandedFormat.add(card);
    }

    public void addUnlimitedFormat(Card card) {
        this.unlimitedFormat.add(card);
    }

}
