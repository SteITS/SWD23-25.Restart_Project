package com.restart.repository;

import com.restart.entity.Deck;
import com.restart.entity.Rating;
import com.restart.entity.RatingId;
import com.restart.entity.SleeveId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, RatingId> {
    List<Rating> findByDeckId(int deckId);
}
