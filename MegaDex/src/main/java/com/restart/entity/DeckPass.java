package com.restart.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DeckPass {
    private Integer cardExcess; //Numero di carte in eccesso o difetto
    private List<String> regulationMarks; //Lista dei regulation marks
    private List<String> tooMany; //Lista dei nomi di carte oltre il x4
    private List<Card> nLStandardFormat; //Lista di carte bannate nel formato Standard
    private List<Card> nLExpandedFormat; //Lista di carte bannate nel formato Expanded
    private List<Card> nLUnlimitedFormat; //Lista di carte bannate nel formato Unlimited

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
