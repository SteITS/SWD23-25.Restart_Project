package com.restart.service;

import com.restart.entity.Rating;

import java.util.List;

public interface RatingService {
    List<Rating> getAllRatings();
    Rating saveRating(Rating rating);
    void removeRating(Rating rating);

}


