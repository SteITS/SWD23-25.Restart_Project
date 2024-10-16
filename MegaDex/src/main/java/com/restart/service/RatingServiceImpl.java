package com.restart.service;

import com.restart.entity.Deck;
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

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public void removeRating(Rating rating) {
        ratingRepository.delete(rating);
    }
}
