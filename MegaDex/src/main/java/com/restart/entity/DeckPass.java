package com.restart.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DeckPass {
    private Integer cardExcess;
    private List<String> regulationMarks;
    private List<String> tooMany;
    private List<Card> nLStandardFormat;
    private List<Card> nLExpandedFormat;
    private List<Card> nLUnlimitedFormat;

    public DeckPass() {
        this.tooMany = new ArrayList<>();
        this.nLStandardFormat = new ArrayList<>();
        this.nLExpandedFormat = new ArrayList<>();
        this.nLUnlimitedFormat = new ArrayList<>();
        this.regulationMarks = new ArrayList<>();
    }

    public void addTooMany(String card) {
        this.tooMany.add(card);
    }

    public void quantityBalancing(Integer deckQuantity) {
        this.cardExcess = deckQuantity-60;
    }

    public void addStandardFormat(Card card) {
        this.nLStandardFormat.add(card);
    }

    public void addExpandedFormat(Card card) {
        this.nLExpandedFormat.add(card);
    }

    public void addUnlimitedFormat(Card card) {
        this.nLUnlimitedFormat.add(card);
    }
    public void addRegulationMark(String regulationMark){ this.regulationMarks.add(regulationMark);}

}
