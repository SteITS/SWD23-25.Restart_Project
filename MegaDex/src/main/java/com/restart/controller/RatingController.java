package com.restart.controller;

import com.restart.entity.*;
import com.restart.service.DeckServiceImpl;
import com.restart.service.RatingService;
import com.restart.service.RatingServiceImpl;
import com.restart.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RatingController {

    @Autowired
    private RatingServiceImpl ratingService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private DeckServiceImpl deckService;

    // Get all ratings
    @PostMapping("/deb/ratings")
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }

    //Aggiunge un rate
    @PostMapping("/auth/updateRating")
    ResponseEntity<Rating> updateRating(@RequestBody Rating ratingRequest) {

        User user = userService.getAuthenticatedUser();
        Deck deck = deckService.getDeckById(ratingRequest.getId().getIdDeck())
                .orElseThrow(() -> new RuntimeException("Deck not found with ID: " + ratingRequest.getId().getIdDeck()));

        // associa deck e utente
        ratingRequest.setUser(user);
        ratingRequest.getId().setIdUser(user.getId());
        ratingRequest.setDeck(deck);


        // Salva il rate
        if(ratingRequest.getRate() != null){
            Rating savedRating = ratingService.saveRating(ratingRequest);
            return ResponseEntity.ok(savedRating);
        }

        else {
            ratingService.removeRating(ratingRequest);
            return ResponseEntity.ok(ratingRequest);
        }
    }

    @PostMapping("/auth/removeRating")
    public ResponseEntity<String> removeRating(@RequestBody Rating ratingRequest){
        // Recupera l'utente dal database usando l'ID passato nella richiesta
        //User user = userService.findUserById(ratingRequest.getId().getIdUser())
        //        .orElseThrow(() -> new RuntimeException("User not found with ID: " + ratingRequest.getId().getIdUser()));

        // Recupera l'utente autenticato
        User user = userService.getAuthenticatedUser();
        Deck deck = deckService.getDeckById(ratingRequest.getId().getIdDeck())
                .orElseThrow(() -> new RuntimeException("Deck not found with ID: " + ratingRequest.getId().getIdUser()));

        // associa deck e utente
        ratingRequest.setUser(user);
        ratingRequest.getId().setIdUser(user.getId());
        ratingRequest.setDeck(deck);

        // rimuove il rating
        try {
            ratingService.removeRating(ratingRequest);
            return ResponseEntity.ok("Rating rimosso con successo");
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

}
