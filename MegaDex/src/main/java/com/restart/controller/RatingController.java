package com.restart.controller;

import com.restart.entity.Rating;
import com.restart.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    // Get all ratings
    @GetMapping
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }

}
