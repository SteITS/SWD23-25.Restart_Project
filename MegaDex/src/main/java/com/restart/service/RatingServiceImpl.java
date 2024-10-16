package com.restart.service;


import com.restart.entity.Rating;
import com.restart.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<Rating> getRatingsByDeckId(int deckId) {
        return ratingRepository.findByDeckId(deckId);
    }
    // Recupera tutti rating dal database

    @Override  
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    // Salva un nuovo rating nel database
    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    // Elimina un rating dal database
    @Override
    public void removeRating(Rating rating) {
        ratingRepository.delete(rating);
    }
}