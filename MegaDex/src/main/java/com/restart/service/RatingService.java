package com.restart.service;

import com.restart.entity.Deck;
import com.restart.entity.Rating;

import java.util.List;

public interface RatingService {
    List<Rating> getRatingsByDeckId(int deckId);
	
    List<Rating> getAllRatings();
    
    Rating saveRating(Rating rating);

    void removeRating(Rating rating);
}


