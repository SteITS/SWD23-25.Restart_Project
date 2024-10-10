package com.restart.dto;

import java.util.List;

import com.restart.entity.Card;
//Data Transfer Object (DTO) used to carry both filtered cards and pagination metadata
public class CardDto {
    private List<Card> cards;  // The list of cards
    private int currentPage;    // The current page number
    private int totalPages;     // The total number of pages available
    private long totalItems;    // The total number of items

    // Constructor
    public CardDto(List<Card> cards, int currentPage, int totalPages, long totalItems) {
        this.cards = cards;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalItems = totalItems;
    }
    //getters and setters
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