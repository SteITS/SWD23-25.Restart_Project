package com.restart.dto;

import java.util.List;

import com.restart.entity.Card;
// Data Transfer Object (DTO) per trasportare sia le carte filtrate che i dati di paginazione
public class CardDto {
    private List<Card> cards;
    private int currentPage;    // Numero pagina corrente
    private int totalPages;     // Totale pagine disponibili
    private long totalItems;    // Numero totale di item

    // Costruttore
    public CardDto(List<Card> cards, int currentPage, int totalPages, long totalItems) {
        this.cards = cards;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalItems = totalItems;
    }
    //getter e setter
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(long totalItems) {
		this.totalItems = totalItems;
	}
    
    
}